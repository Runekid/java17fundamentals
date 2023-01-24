package be.onurbugdayci.beers.services;

import be.onurbugdayci.beers.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface BeerRepository extends JpaRepository<Beer, Integer> {
    default Beer getBeerById(int id) {
        return findById(id).orElse(null);
    }

    @Query(name = "findByAlcohol")
    List<Beer> getBeerByAlcohol(float alcohol);


    default void updateBeer(Beer b) {
        save(b);
    }

    List<Beer> getBeerByNameContainingOrderByNameAsc(String substring);
    List<Beer> getBeerByStockLessThan(int ceilingStockAmount);

    @Transactional
    @Modifying
    @Query("update Beer b set b.price = b.price * :percentage")
    void updatePriceByPercentage(@Param("percentage") float perc);
}
