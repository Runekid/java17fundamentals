package be.onurbugdayci.product.services;

import be.onurbugdayci.jpa.ProductJPA;

import java.math.BigDecimal;
import java.util.Random;

public class ProductFixture {
    public static ProductJPA getRandomProductJPA() {
        Random random = new Random();
        ProductJPA productJPA = new ProductJPA();
        productJPA.setId(random.nextLong());
        productJPA.setName("test" + random.nextInt());
        productJPA.setDescription("test description" + random.nextInt());
        productJPA.setPrice(BigDecimal.valueOf(random.nextDouble()));
        return productJPA;
    }

}
