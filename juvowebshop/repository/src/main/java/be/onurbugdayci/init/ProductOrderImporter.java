package be.onurbugdayci.init;

import be.onurbugdayci.jpa.ProductJPA;
import be.onurbugdayci.jpa.ProductOrderEntryJPA;
import be.onurbugdayci.jpa.ProductOrderJPA;
import be.onurbugdayci.jpa.UserJPA;
import be.onurbugdayci.repositories.ProductOrderEntryRepository;
import be.onurbugdayci.repositories.ProductOrderRepository;
import be.onurbugdayci.repositories.ProductRepository;
import be.onurbugdayci.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//test to see if I created my relations correctly but I don't need this in the main app
//@Component
public class ProductOrderImporter implements CommandLineRunner {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Autowired
    private ProductOrderEntryRepository productOrderEntryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        List<ProductOrderEntryJPA> entries = new ArrayList<>();
        ProductOrderJPA productOrderJPA = new ProductOrderJPA();
        ProductOrderEntryJPA productOrderEntryJPA = new ProductOrderEntryJPA();
        ProductJPA productJPA = new ProductJPA();
        UserJPA userJPA = new UserJPA();
        productRepository.save(productJPA);
        userRepository.save(userJPA);

        productOrderEntryJPA.setAmount(1);
        productOrderEntryJPA.setCalculatedPrice(new BigDecimal("10.00"));

        productOrderJPA.setOrderCompleted(false);
        productOrderJPA.setPurchaseDate(LocalDate.now());
        productOrderJPA.setTotalPrice(new BigDecimal("10.00"));
        productOrderJPA.setUser(userJPA);
        productOrderRepository.save(productOrderJPA);
        productOrderEntryJPA.setProduct(productJPA);

        productOrderEntryRepository.save(productOrderEntryJPA);

    }
}
