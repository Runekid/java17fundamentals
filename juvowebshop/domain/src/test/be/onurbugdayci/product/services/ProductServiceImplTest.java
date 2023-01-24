package be.onurbugdayci.product.services;

import be.onurbugdayci.jpa.ProductJPA;
import be.onurbugdayci.product.domain.Product;
import be.onurbugdayci.product.mapper.ProductMapperImpl;
import be.onurbugdayci.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {ProductServiceImpl.class, ProductMapperImpl.class})
class ProductServiceImplTest {

    @Autowired
    private ProductService service;
    @MockBean
    private ProductRepository repository;


    @Test
    void testFindAllProducts() {
        List<ProductJPA> productJPAS = new ArrayList<>();
        ProductJPA productJPA = ProductFixture.getRandomProductJPA();
        productJPAS.add(productJPA);

        Mockito.when(repository.findAll()).thenReturn(productJPAS);

        assertEquals(1,service.findAllProducts().size());
        Product product = service.findAllProducts().get(0);
        assertEquals(productJPA.getId(),product.getId());
        assertEquals(productJPA.getName(),product.getName());
        assertEquals(productJPA.getDescription(),product.getDescription());
        assertEquals(productJPA.getPrice(),product.getPrice());

    }

    @Test
    void testFindAllProductsWithNameLike() {
        List<ProductJPA> productJPAS = new ArrayList<>();
        ProductJPA productJPA = ProductFixture.getRandomProductJPA();
        productJPAS.add(productJPA);
        ProductJPA productJPAToFind = ProductFixture.getRandomProductJPA();
        productJPAS.add(productJPAToFind);

        Mockito.when(repository.findByNameIsLike(productJPAToFind.getName())).thenReturn(List.of(productJPAToFind));

        assertEquals(1,service.findAllProductsWithNameLike(productJPAToFind.getName()).size());
        Product product = service.findAllProductsWithNameLike(productJPAToFind.getName()).get(0);
        assertEquals(productJPAToFind.getId(),product.getId());
        assertEquals(productJPAToFind.getName(),product.getName());
        assertEquals(productJPAToFind.getDescription(),product.getDescription());
        assertEquals(productJPAToFind.getPrice(),product.getPrice());
    }

    @Test
    void testFindProductByID() {
        ProductJPA productJPA = ProductFixture.getRandomProductJPA();

        Mockito.when(repository.getProductById(productJPA.getId())).thenReturn(productJPA);

        assertNotNull(service.findProductByID(productJPA.getId()));
        Product product = service.findProductByID(productJPA.getId());
        assertEquals(productJPA.getId(),product.getId());
        assertEquals(productJPA.getName(),product.getName());
        assertEquals(productJPA.getDescription(),product.getDescription());
        assertEquals(productJPA.getPrice(),product.getPrice());
    }
}