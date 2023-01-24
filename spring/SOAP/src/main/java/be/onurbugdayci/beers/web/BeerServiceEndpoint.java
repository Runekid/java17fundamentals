package be.onurbugdayci.beers.web;

import be.onurbugdayci.beers.domain.Beer;
import be.onurbugdayci.beers.services.BeerRepository;
import be.onurbugdayci.beers.services.BeerService;
import be.onurbugdayci.beers.services.InvalidBeerException;
import be.onurbugdayci.beers.services.InvalidNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;


@Service
@WebService(serviceName = "BeerService")
public class BeerServiceEndpoint {

    @Autowired
    private BeerService beerService;

    @Autowired
    private BeerRepository beerRepository;

    public int orderBeer(String name, int id, int number) throws InvalidNumberException, InvalidBeerException {
        return beerService.orderBeer(name,id,number);
    }

    public Beer getBeerById(int id) {
        return beerRepository.getBeerById(id);
    }
}
