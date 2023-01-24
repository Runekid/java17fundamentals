package be.onurbugdayci.order.services;

import be.onurbugdayci.jpa.ProductJPA;
import be.onurbugdayci.jpa.ProductOrderJPA;
import be.onurbugdayci.jpa.UserJPA;
import be.onurbugdayci.order.domain.ProductOrder;
import be.onurbugdayci.order.domain.ProductOrderEntry;
import be.onurbugdayci.order.domain.ProductOrderList;
import be.onurbugdayci.order.mapper.ProductOrderEntryMapperImpl;
import be.onurbugdayci.order.mapper.ProductOrderMapper;
import be.onurbugdayci.order.mapper.ProductOrderMapperImpl;
import be.onurbugdayci.product.domain.Product;
import be.onurbugdayci.product.mapper.ProductMapper;
import be.onurbugdayci.product.mapper.ProductMapperImpl;
import be.onurbugdayci.product.services.ProductService;
import be.onurbugdayci.repositories.ProductOrderRepository;
import be.onurbugdayci.repositories.ProductRepository;
import be.onurbugdayci.repositories.UserRepository;
import be.onurbugdayci.user.domain.User;
import be.onurbugdayci.user.mapper.UserMapper;
import be.onurbugdayci.user.mapper.UserMapperImpl;
import be.onurbugdayci.user.services.UserService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {ProductOrderServiceImpl.class, ProductOrderMapperImpl.class})
class ProductOrderServiceImplTest {

    @Autowired
    private ProductOrderService service;
    @Autowired
    private ProductOrderMapper mapper;
    @MockBean
    private ProductOrderRepository repository;
    @MockBean
    private ProductService productService;
    @MockBean
    private UserService userService;

    @MockBean
    private ProductOrderEntryService productOrderEntryService;


    @Test
    public void testUpdateOrCreateProductOrderEntry() {
        long productId = 1;
        int amount = 2;
        User user = new User();
        user.setId(1L);
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal("10.00"));
        ProductOrderJPA productOrderJPA = new ProductOrderJPA();
        productOrderJPA.setId(1L);




        Mockito.when(userService.findLoggedInUser()).thenReturn(user);
        Mockito.when(productService.findProductByID(productId)).thenReturn(product);
        Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(productOrderJPA);





        ProductOrder productOrder = service.updateOrCreateProductOrderEntry(productId,amount);

        assertEquals(1, productOrder.getProductOrderEntryList().size());
        assertEquals(productId, productOrder.getProductOrderEntryList().get(0).getProduct().getId());
        assertEquals(amount, productOrder.getProductOrderEntryList().get(0).getAmount());
        assertEquals(new BigDecimal("20.00"), productOrder.getTotalPrice());
        assertEquals(new BigDecimal("20.00"), productOrder.getProductOrderEntryList().get(0).getCalculatedPrice());
        Mockito.verify(repository, Mockito.times(2)).save(ArgumentMatchers.any()); // saved once in createCurrentProductOrder and a second time in saveProductOrder in updateOrCreateProductOrderEntry when it's updated
    }

    @Test
    public void testRemoveProductOrderEntry() {
        long productOrderId = 1L;
        long productOrderEntryId = 1L;

        ProductOrder productOrder = ProductOrderFixture.getProductOrder(productOrderId,productOrderEntryId);

        ProductOrderJPA productOrderJPA = mapper.mapToProductOrderJPA(productOrder);

        assertFalse(productOrder.getProductOrderEntryList().isEmpty());
        assertEquals(productOrder.getTotalPrice(),new BigDecimal("10.00"));

        Mockito.when(productOrderEntryService.findById(productOrderEntryId)).thenReturn(productOrder.getProductOrderEntryList().get(0));
        Mockito.when(repository.findById(productOrderId)).thenReturn(Optional.ofNullable(productOrderJPA));
        Mockito.when(repository.save(ArgumentMatchers.any())).then(invocationOnMock -> invocationOnMock.getArgument(0));

        productOrder = service.removeProductOrderEntry(productOrderEntryId);

        assertTrue(productOrder.getProductOrderEntryList().isEmpty());
        assertEquals(new BigDecimal("0.0"),productOrder.getTotalPrice());


    }

    @Test
    public void testCompleteProductOrder() {
        long productOrderId = 1L;
        ProductOrder productOrder = new ProductOrder();
        productOrder.setId(productOrderId);

        assertFalse(productOrder.isOrderCompleted());
        assertNull(productOrder.getPurchaseDate());
        assertNull(productOrder.getPurchaseTime());

        ProductOrderJPA productOrderJPA = mapper.mapToProductOrderJPA(productOrder);

        Mockito.when(repository.findById(productOrderId)).thenReturn(Optional.ofNullable(productOrderJPA));
        Mockito.when(repository.save(ArgumentMatchers.any())).then(invocationOnMock -> invocationOnMock.getArgument(0));

        productOrder = service.completeProductOrder(productOrderId);

        assertTrue(productOrder.isOrderCompleted());
        assertNotNull(productOrder.getPurchaseDate());
        assertNotNull(productOrder.getPurchaseTime());
    }

    @Test
    void testFindAllOrders() {
        //probably overkill to do the rest of the find methods in the ProductOrderService since the logic is in the repository, here I atleast tested if the mapper does its job...
        List<ProductOrderJPA> productOrderJPAs = new ArrayList<>();
        ProductOrderJPA productOrderJPA = ProductOrderFixture.getRandomCompletedProductOrderJPA();
        productOrderJPAs.add(productOrderJPA);

        Mockito.when(repository.findAllByOrderCompletedTrue()).thenReturn(productOrderJPAs);

        ProductOrderList productOrderList = service.findAllOrders();

        assertFalse(productOrderList.orderList().isEmpty());
        assertEquals(productOrderJPA.getId(), productOrderList.orderList().get(0).getId());
        assertEquals(productOrderJPA.getUser().getId(), productOrderList.orderList().get(0).getUser().getId());
        assertEquals(productOrderJPA.getUser().getUsername(), productOrderList.orderList().get(0).getUser().getUsername());
        assertEquals(productOrderJPA.getUser().getPasswordbc(), productOrderList.orderList().get(0).getUser().getPasswordbc());
        assertEquals(productOrderJPA.getPurchaseDate(), productOrderList.orderList().get(0).getPurchaseDate());
        assertEquals(productOrderJPA.getPurchaseTime(), productOrderList.orderList().get(0).getPurchaseTime());
        assertEquals(productOrderJPA.isOrderCompleted(),productOrderList.orderList().get(0).isOrderCompleted());
        assertEquals(productOrderJPA.getProductOrderEntryList().get(0).getId(),productOrderList.orderList().get(0).getProductOrderEntryList().get(0).getId());
        assertEquals(productOrderJPA.getProductOrderEntryList().get(0).getAmount(),productOrderList.orderList().get(0).getProductOrderEntryList().get(0).getAmount());
        assertEquals(productOrderJPA.getProductOrderEntryList().get(0).getCalculatedPrice(),productOrderList.orderList().get(0).getProductOrderEntryList().get(0).getCalculatedPrice());
        assertEquals(productOrderJPA.getProductOrderEntryList().get(0).getProductOrderId(),productOrderList.orderList().get(0).getProductOrderEntryList().get(0).getProductOrderId());
        assertEquals(productOrderJPA.getProductOrderEntryList().get(0).getProduct().getId(),productOrderList.orderList().get(0).getProductOrderEntryList().get(0).getProduct().getId());
        assertEquals(productOrderJPA.getProductOrderEntryList().get(0).getProduct().getName(),productOrderList.orderList().get(0).getProductOrderEntryList().get(0).getProduct().getName());
        assertEquals(productOrderJPA.getProductOrderEntryList().get(0).getProduct().getDescription(),productOrderList.orderList().get(0).getProductOrderEntryList().get(0).getProduct().getDescription());
        assertEquals(productOrderJPA.getProductOrderEntryList().get(0).getProduct().getPrice(),productOrderList.orderList().get(0).getProductOrderEntryList().get(0).getProduct().getPrice());

    }
}