package be.onurbugdayci.beers;

import be.onurbugdayci.beers.domain.Beer;
import be.onurbugdayci.beers.domain.BeerOrder;
import be.onurbugdayci.beers.domain.BeerOrderItem;
import be.onurbugdayci.beers.services.BeerOrderRepository;
import be.onurbugdayci.beers.services.BeerRepository;
import be.onurbugdayci.beers.services.BrewerRepository;
import be.onurbugdayci.beers.services.CategoryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

@SpringBootApplication
public class BeerApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(BeerApp.class, args);
        BeerRepository beerRepository = ctx.getBean("beerRepository", BeerRepository.class);

        //beerRepository.getBeerByNameContainingOrderByNameAsc("duv").stream().forEach(System.out::println);

        //beerRepository.getBeerByStockLessThan(101).stream().forEach(System.out::println);

        //beerRepository.updatePriceByPercentage(1.01F);

        /*ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnorePaths("id","version","stock","price")
                .withMatcher("name", name -> name.ignoreCase().startsWith());

        Beer beer = new Beer();
        beer.setAlcohol(9F);
        beer.setName("st");
        Example<Beer> beerExample = Example.of(beer, matcher);

        List<Beer> beers = beerRepository.findAll(beerExample);
        beers.stream().forEach(System.out::println);*/

        //System.out.println(beerRepository.count());

        //System.out.println(beerRepository.existsById(15));

        BrewerRepository brewerRepository = ctx.getBean("brewerRepository", BrewerRepository.class);
        System.out.println(brewerRepository.findById(1).get());

        CategoryRepository categoryRepository = ctx.getBean("categoryRepository", CategoryRepository.class);
        //categoryRepository.findAll().stream().forEach(cat -> System.out.println(cat.getId()));
        System.out.println(categoryRepository.findById(11).get());


    }


}
