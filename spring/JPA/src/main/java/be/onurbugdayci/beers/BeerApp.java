package be.onurbugdayci.beers;

import be.onurbugdayci.beers.dao.BeerDao;
import be.onurbugdayci.beers.domain.Beer;
import be.onurbugdayci.beers.domain.BeerOrder;
import be.onurbugdayci.beers.domain.BeerOrderItem;
import be.onurbugdayci.beers.services.BeerOrderRepository;
import be.onurbugdayci.beers.services.BeerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BeerApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(BeerApp.class, args);
        BeerRepository beerRepository = ctx.getBean("beerRepository", BeerRepository.class);
       /* System.out.println(beerRepository.getBeerById(20));
        Beer beer = beerRepository.getBeerById(20);
        beer.setStock(50);
        beerRepository.updateBeer(beer);
        System.out.println(beerRepository.getBeerById(20));*/
        //beerRepository.getBeerByAlcohol(8F).forEach(System.out::println);

        BeerOrderRepository beerOrderRepository = ctx.getBean("beerOrderRepository",BeerOrderRepository.class);

        BeerOrderItem item = new BeerOrderItem();
        item.setBeer(beerRepository.getBeerById(20));
        item.setNumber(5);

        BeerOrder beerOrder = new BeerOrder();
        beerOrder.setName("testOrder");
        beerOrder.getItems().add(item);
        int beerOrderId = beerOrderRepository.saveOrder(beerOrder);
        System.out.println(beerOrderRepository.getBeerOrderById(beerOrderId).getName());

    }


}
