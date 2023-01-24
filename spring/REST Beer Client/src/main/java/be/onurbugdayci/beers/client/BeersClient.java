package be.onurbugdayci.beers.client;

import be.onurbugdayci.beers.domain.Beer;
import be.onurbugdayci.beers.domain.BeerList;
import be.onurbugdayci.beers.domain.BeerOrder;
import be.onurbugdayci.beers.domain.BeerOrderRequest;

import java.net.URI;

public interface BeersClient {
    public Beer getBeerById(int id);
    public BeerList getBeerByAlcohol(float alcohol);
    public BeerList getBeerByName(String name);
    public URI addOrder(BeerOrderRequest beerOrderRequest);
    public BeerOrder getOrderById(int id);

}
