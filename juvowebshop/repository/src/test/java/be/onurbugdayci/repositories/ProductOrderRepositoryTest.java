package be.onurbugdayci.repositories;

import be.onurbugdayci.jpa.ProductOrderJPA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Sql("/sql/productOrderRepository/productOrderRepository.sql")
class ProductOrderRepositoryTest {

    @Autowired
    private ProductOrderRepository repository;

    @Test
    void findProductOrderJPAByUser_IdEqualsAndOrderCompletedFalse() {
        ProductOrderJPA productOrderJPA = repository.findProductOrderJPAByUser_IdEqualsAndOrderCompletedFalse(1);
        assertFalse(productOrderJPA.isOrderCompleted());
        assertEquals(1, productOrderJPA.getUser().getId());
    }

    @Test
    void findAllByOrderCompletedTrue() {
        List<ProductOrderJPA> productOrderJPAList = repository.findAllByOrderCompletedTrue();
        assertEquals(3, productOrderJPAList.size());
    }

    @Test
    void findAllOrdersOfToday() {
        List<ProductOrderJPA> productOrderJPAList = repository.findAllOrdersOfToday();
        assertEquals(1, productOrderJPAList.size());
        assertEquals(3,productOrderJPAList.get(0).getId());
    }

    @Test
    void findAllByPurchaseDateBeforeAndOrderCompletedTrue() {
        List<ProductOrderJPA> productOrderJPAList = repository
                .findAllByPurchaseDateBeforeAndOrderCompletedTrue(LocalDate.now().plusDays(1));
        assertEquals(1, productOrderJPAList.size());
        assertEquals(3,productOrderJPAList.get(0).getId());
    }

    @Test
    void findAllByPurchaseDateAfterAndOrderCompletedTrue() {
        List<ProductOrderJPA> productOrderJPAList = repository
                .findAllByPurchaseDateAfterAndOrderCompletedTrue(LocalDate.now());
        assertEquals(1, productOrderJPAList.size());
        assertEquals(4,productOrderJPAList.get(0).getId());
    }

    @Test
    void findAllByPurchaseDateBetweenAndOrderCompletedTrue() {
        List<ProductOrderJPA> productOrderJPAList = repository
                .findAllByPurchaseDateBetweenAndOrderCompletedTrue(LocalDate.now().minusDays(1),LocalDate.now());
        assertEquals(1, productOrderJPAList.size());
        assertEquals(3,productOrderJPAList.get(0).getId());
    }
}