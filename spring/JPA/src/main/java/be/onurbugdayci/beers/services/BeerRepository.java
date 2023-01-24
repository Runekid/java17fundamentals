package be.onurbugdayci.beers.services;

import be.onurbugdayci.beers.domain.Beer;

import java.util.List;

public interface BeerRepository {
    Beer getBeerById(int id);
    List<Beer> getBeerByAlcohol(float alcohol);
    void updateBeer(Beer b);
}
