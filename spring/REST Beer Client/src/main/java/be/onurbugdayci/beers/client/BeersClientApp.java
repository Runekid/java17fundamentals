package be.onurbugdayci.beers.client;

import be.onurbugdayci.beers.domain.BeerList;
import be.onurbugdayci.beers.domain.BeerOrder;
import be.onurbugdayci.beers.domain.BeerOrderRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BeersClientApp {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.requestFactory(
                        HttpComponentsClientHttpRequestFactory::new)
                .basicAuthentication("user", "password").build();
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(BeersClientApp.class, args);
        BeersClient beersClient =
                ctx.getBean(BeersClient.class);
        BeerList beer = beersClient.getBeerByName("duvel");
        System.out.println(beer.getBeerList().get(0).getId());

        BeerList list = beersClient.getBeerByAlcohol(8);
        //list.getBeerList().forEach(System.out::println);

        //System.out.println(beersClient.addOrder(new BeerOrderRequest("onurrest", 454, 3)));

        BeerOrder beerOrder = beersClient.getOrderById(7);
        System.out.println(beerOrder.getName());
    }
}
