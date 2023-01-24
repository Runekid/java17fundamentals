package be.onurbugdayci;

import be.onurbugdayci.product.domain.Product;
import be.onurbugdayci.jpa.ProductJPA;
import be.onurbugdayci.product.mapper.ProductMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class domApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(domApp.class,args);
        Product product = new Product();
        product.setId(1L);
        product.setName("pro");
        product.setDescription("des");
        product.setImage(new byte[]{0,0,0});
        ProductMapper productMapper = ctx.getBean(ProductMapper.class);
        ProductJPA productJPA = productMapper.mapToProductJPA(product);
        System.out.println(productJPA);


    }
}
