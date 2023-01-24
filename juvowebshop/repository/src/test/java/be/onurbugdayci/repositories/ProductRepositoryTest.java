package be.onurbugdayci.repositories;

import be.onurbugdayci.jpa.ProductJPA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;


    @Test
    @Sql("/sql/productRepository/productById.sql")
    void getProductById() {
        ProductJPA productJPA = repository.getProductById(1);
        assertEquals("test",productJPA.getName());
    }

    @Test
    @Sql("/sql/productRepository/findByNameIsLike.sql")
    void findByNameIsLike() {
        List<ProductJPA> productJPAList = repository.findByNameIsLike("li");
        assertEquals(1,productJPAList.size());
        assertEquals("like",productJPAList.get(0).getName());

    }
}