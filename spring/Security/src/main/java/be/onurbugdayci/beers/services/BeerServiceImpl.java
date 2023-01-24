package be.onurbugdayci.beers.services;

import be.onurbugdayci.beers.domain.Beer;
import be.onurbugdayci.beers.domain.BeerOrder;
import be.onurbugdayci.beers.domain.BeerOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

@Component
public class BeerServiceImpl implements BeerService{

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private BeerOrderRepository beerOrderRepository;

    @Override
    @Secured({"ROLE_ADULT"})
    @Transactional
    public int orderBeer(String name, int beerId, int number) throws InvalidNumberException, InvalidBeerException {
        Beer beer = beerRepository.getBeerById(beerId);
        if (beer == null) {
            throw new InvalidBeerException("Beer " + beerId
                    + " does not exist");
        }
        if (number < 0)
            throw new InvalidNumberException("Number " + number
                    + " is invalid");

        BeerOrderItem item = new BeerOrderItem();
        item.setNumber(number);
        item.setBeer(beer);
        BeerOrder order = new BeerOrder();
        order.getItems().add(item);
        order.setName(name);
        int orderId = beerOrderRepository.saveOrder(order);
        beer.setStock(beer.getStock() - number);
        beerRepository.updateBeer(beer);
        return orderId;
    }
}
