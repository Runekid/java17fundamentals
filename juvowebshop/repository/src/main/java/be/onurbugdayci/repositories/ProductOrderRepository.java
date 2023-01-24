package be.onurbugdayci.repositories;

import be.onurbugdayci.jpa.ProductOrderJPA;
import be.onurbugdayci.jpa.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ProductOrderRepository extends JpaRepository<ProductOrderJPA, Long> {
    ProductOrderJPA findProductOrderJPAByUser_IdEqualsAndOrderCompletedFalse(long id);

    List<ProductOrderJPA> findAllByOrderCompletedTrue();
    @Query(name = "findAllOrdersOfToday")
    List<ProductOrderJPA> findAllOrdersOfToday();

    List<ProductOrderJPA> findAllByPurchaseDateBeforeAndOrderCompletedTrue(LocalDate date);
    List<ProductOrderJPA> findAllByPurchaseDateAfterAndOrderCompletedTrue(LocalDate date);
    List<ProductOrderJPA> findAllByPurchaseDateBetweenAndOrderCompletedTrue(LocalDate startDate, LocalDate endDate);


}
