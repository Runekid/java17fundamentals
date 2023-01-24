package be.onurbugdayci.order.services;

import be.onurbugdayci.jpa.ProductOrderJPA;
import be.onurbugdayci.order.domain.ProductOrder;
import be.onurbugdayci.order.domain.ProductOrderEntry;
import be.onurbugdayci.order.domain.ProductOrderList;
import be.onurbugdayci.order.mapper.ProductOrderMapper;
import be.onurbugdayci.product.domain.Product;
import be.onurbugdayci.product.services.ProductService;
import be.onurbugdayci.repositories.ProductOrderRepository;
import be.onurbugdayci.user.domain.User;
import be.onurbugdayci.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service("productOrderService")
@RequiredArgsConstructor
public class ProductOrderServiceImpl implements ProductOrderService {

    private final ProductOrderRepository repository;
    private final ProductOrderMapper mapper;
    private final ProductOrderEntryService productOrderEntryService;
    private final UserService userService;
    private final ProductService productService;

    public ProductOrder findCurrentProductOrder() {
        User user = userService.findLoggedInUser();
        ProductOrderJPA productOrderJPA = repository.findProductOrderJPAByUser_IdEqualsAndOrderCompletedFalse(user.getId());
        if (productOrderJPA == null) {
            return createCurrentProductOrder(user);
        }
        return mapper.mapToProductOrder(productOrderJPA);
    }

    public ProductOrder createCurrentProductOrder(User user) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setOrderCompleted(false);
        productOrder.setUser(user);
        productOrder.setProductOrderEntryList(new ArrayList<>());
        ProductOrderJPA productOrderJPA = repository.save(mapper.mapToProductOrderJPA(productOrder));
        productOrder.setId(productOrderJPA.getId());
        return productOrder;
    }

    public ProductOrder updateOrCreateProductOrderEntry(Product product, Integer amount) {
        ProductOrder productOrder = findCurrentProductOrder();

        ProductOrderEntry productOrderEntry = getProductOrderEntry(product.getId(), productOrder)
                .orElse(createProductOrderEntry(product, productOrder));

        productOrderEntry.setAmount(calculateAmount(amount, productOrderEntry.getAmount()));
        productOrderEntry
                .setCalculatedPrice(calculateProductOrderEntryPrice(productOrderEntry));


        if (!productOrder.getProductOrderEntryList().contains(productOrderEntry)) {
            productOrder.getProductOrderEntryList().add(productOrderEntry);
        }

        productOrder
                .setTotalPrice(calculateProductOrderTotalPrice(productOrder));

        saveProductOrder(productOrder);

        return productOrder;
    }

    private void saveProductOrder(ProductOrder productOrder) {
        ProductOrderJPA productOrderJPA = mapper.mapToProductOrderJPA(productOrder);
        repository.save(productOrderJPA);
    }

    private BigDecimal calculateProductOrderTotalPrice(ProductOrder productOrder) {
        return productOrder
                .getProductOrderEntryList()
                .stream()
                .map(ProductOrderEntry::getCalculatedPrice)
                .reduce(new BigDecimal("0.0"), BigDecimal::add);
    }

    private BigDecimal calculateProductOrderEntryPrice(ProductOrderEntry productOrderEntry) {
        return productOrderEntry.getProduct().getPrice()
                .multiply(BigDecimal.valueOf(productOrderEntry.getAmount()));
    }

    private int calculateAmount(Integer amount, int currentAmount) {
        return currentAmount + Objects.requireNonNullElse(amount, 1);
    }

    private ProductOrderEntry createProductOrderEntry(Product product, ProductOrder productOrder) {
        ProductOrderEntry productOrderEntry = new ProductOrderEntry();
        productOrderEntry.setProduct(product);
        productOrderEntry.setProductOrderId(productOrder.getId());
        productOrderEntry.setAmount(0);
        return productOrderEntry;
    }

    protected Optional<ProductOrderEntry> getProductOrderEntry(long productId, ProductOrder productOrder) {
        return productOrder
                .getProductOrderEntryList()
                .stream()
                .filter(poe -> productId == poe.getProduct().getId())
                .findAny();
    }


    public ProductOrder updateOrCreateProductOrderEntry(long productId, Integer amount) {
        Product product = productService.findProductByID(productId);
        return updateOrCreateProductOrderEntry(product, amount);
    }

    public ProductOrder removeProductOrderEntry(long productOrderEntryId) {
        ProductOrderEntry productOrderEntry = productOrderEntryService.findById(productOrderEntryId);
        long productOrderId = productOrderEntry.getProductOrderId();
        ProductOrder productOrder = mapper.mapToProductOrder(repository.findById(productOrderId).get());
        productOrder.getProductOrderEntryList().remove(productOrderEntry);
        calculateTotalPrice(productOrder);
        return mapper.mapToProductOrder(repository.save(mapper.mapToProductOrderJPA(productOrder)));
    }

    private void calculateTotalPrice(ProductOrder productOrder) {
        productOrder
                .setTotalPrice(productOrder
                        .getProductOrderEntryList()
                        .stream()
                        .map(ProductOrderEntry::getCalculatedPrice)
                        .reduce(new BigDecimal("0.0"), BigDecimal::add));
    }

    public ProductOrder completeProductOrder(long productOrderId) {
        ProductOrder productOrder = mapper.mapToProductOrder(repository.findById(productOrderId).get());
        productOrder.setOrderCompleted(true);
        productOrder.setPurchaseDate(LocalDate.now());
        productOrder.setPurchaseTime(LocalTime.now());
        return mapper.mapToProductOrder(repository.save(mapper.mapToProductOrderJPA(productOrder)));
    }

    public ProductOrderList findAllOrdersOfToday() {
        List<ProductOrderJPA> productOrderJPAS = repository.findAllOrdersOfToday();
        List<ProductOrder> productOrders = productOrderJPAS
                .stream()
                .map(jpa -> mapper.mapToProductOrder(jpa))
                .toList();
        return new ProductOrderList(productOrders);
    }

    public ProductOrderList findAllOrders() {
        List<ProductOrderJPA> productOrderJPAS = repository.findAllByOrderCompletedTrue();
        List<ProductOrder> productOrders = productOrderJPAS
                .stream()
                .map(jpa -> mapper.mapToProductOrder(jpa))
                .toList();
        return new ProductOrderList(productOrders);
    }

    @Override
    public ProductOrderList findAllByPurchaseDateBefore(LocalDate date) {
        List<ProductOrderJPA> productOrderJPAS = repository.findAllByPurchaseDateBeforeAndOrderCompletedTrue(date);
        List<ProductOrder> productOrders = productOrderJPAS
                .stream()
                .map(jpa -> mapper.mapToProductOrder(jpa))
                .toList();
        return new ProductOrderList(productOrders);
    }

    @Override
    public ProductOrderList findAllByPurchaseDateAfter(LocalDate date) {
        List<ProductOrderJPA> productOrderJPAS = repository.findAllByPurchaseDateAfterAndOrderCompletedTrue(date);
        List<ProductOrder> productOrders = productOrderJPAS
                .stream()
                .map(jpa -> mapper.mapToProductOrder(jpa))
                .toList();
        return new ProductOrderList(productOrders);
    }

    @Override
    public ProductOrderList findAllByPurchaseDateBetween(LocalDate startDate, LocalDate endDate) {
        List<ProductOrderJPA> productOrderJPAS = repository.findAllByPurchaseDateBetweenAndOrderCompletedTrue(startDate, endDate);
        List<ProductOrder> productOrders = productOrderJPAS
                .stream()
                .map(jpa -> mapper.mapToProductOrder(jpa))
                .toList();
        return new ProductOrderList(productOrders);
    }

}
