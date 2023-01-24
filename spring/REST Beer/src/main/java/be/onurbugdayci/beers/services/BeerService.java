package be.onurbugdayci.beers.services;

public interface BeerService {
    int orderBeer(String name, int beerId, int number) throws InvalidNumberException, InvalidBeerException;
}
