package be.onurbugdayci.beers;

import be.onurbugdayci.beers.dao.BeerDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BeerApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(BeerApp.class, args);
        BeerDao dao = ctx.getBean("beerDao", BeerDao.class);
        System.out.println(dao.getBeerById(20));
        dao.setStock(10,200);
        dao.getBeerByAlcohol(8F).forEach(System.out::println);
    }


}
