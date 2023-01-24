package be.onurbugdayci.beers.services;

import be.onurbugdayci.beers.domain.BeerOrder;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BeerOrderRepository extends JpaRepository<BeerOrder,Integer> {
    default int saveOrder(BeerOrder beerOrder) {
        save(beerOrder);
        return beerOrder.getId();
    }

    default BeerOrder getBeerOrderById(int id){
        return findById(id).orElse(null);
    }
}
