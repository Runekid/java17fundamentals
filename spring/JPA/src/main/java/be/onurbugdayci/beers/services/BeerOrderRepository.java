package be.onurbugdayci.beers.services;

import be.onurbugdayci.beers.domain.BeerOrder;

public interface BeerOrderRepository {
    int saveOrder(BeerOrder beerOrder);
    BeerOrder getBeerOrderById(int id);
}
