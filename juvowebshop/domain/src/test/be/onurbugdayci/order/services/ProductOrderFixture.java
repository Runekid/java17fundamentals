package be.onurbugdayci.order.services;

import be.onurbugdayci.jpa.ProductJPA;
import be.onurbugdayci.jpa.ProductOrderEntryJPA;
import be.onurbugdayci.jpa.ProductOrderJPA;
import be.onurbugdayci.jpa.UserJPA;
import be.onurbugdayci.order.domain.ProductOrder;
import be.onurbugdayci.order.domain.ProductOrderEntry;
import be.onurbugdayci.product.services.ProductFixture;
import be.onurbugdayci.user.services.UserFixture;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

public class ProductOrderFixture {
    public static ProductOrder getProductOrder(long productOrderId,long productOrderEntryId) {
        ProductOrder productOrder = new ProductOrder();
        ProductOrderEntry productOrderEntry = new ProductOrderEntry();
        productOrder.setId(productOrderId);
        productOrder.setProductOrderEntryList(List.of(productOrderEntry));
        productOrder.setTotalPrice(new BigDecimal("10.00"));
        productOrderEntry.setId(productOrderEntryId);
        productOrderEntry.setProductOrderId(productOrderId);

        return productOrder;
    }

    public static ProductOrderJPA getRandomCompletedProductOrderJPA() {
        Random random = new Random();
        ProductJPA productJPA = ProductFixture.getRandomProductJPA();
        UserJPA userJPA = UserFixture.getUserJPA();
        ProductOrderJPA productOrderJPA = new ProductOrderJPA();
        ProductOrderEntryJPA productOrderEntryJPA = new ProductOrderEntryJPA();
        productOrderJPA.setId(random.nextLong());
        productOrderJPA.setProductOrderEntryList(List.of(productOrderEntryJPA));
        productOrderJPA.setTotalPrice(BigDecimal.valueOf(random.nextDouble()));
        productOrderEntryJPA.setId(random.nextLong());
        productOrderEntryJPA.setProductOrderId(productOrderJPA.getId());
        productOrderEntryJPA.setProduct(productJPA);
        productOrderEntryJPA.setAmount(1);
        productOrderEntryJPA.setCalculatedPrice(BigDecimal.valueOf(random.nextDouble()));
        productOrderJPA.setOrderCompleted(true);
        productOrderJPA.setUser(userJPA);
        productOrderJPA.setPurchaseDate(LocalDate.now());
        productOrderJPA.setPurchaseTime(LocalTime.now());
        return productOrderJPA;
    }
}
