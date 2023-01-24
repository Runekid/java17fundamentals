package be.onurbugdayci.beers.services;

import be.onurbugdayci.beers.domain.Beer;
import org.springframework.security.access.annotation.Secured;

public interface BeerService {
    int orderBeer(String name, int beerId, int number) throws InvalidNumberException, InvalidBeerException;
}
