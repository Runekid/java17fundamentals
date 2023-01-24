package be.onurbugdayci.beers;

import be.onurbugdayci.beers.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class BeerApp {



    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(BeerApp.class, args);

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = new UsernamePasswordAuthenticationToken("homer","password");
        securityContext.setAuthentication(authentication);

        /*BeerRepository beerRepository = ctx.getBean("beerRepository", BeerRepository.class);
        beerRepository.findAll().stream().forEach(b -> System.out.println(b.getId()));*/


        BeerService beerService = ctx.getBean("beerServiceImpl", BeerServiceImpl.class);
        try {
            beerService.orderBeer("onurbeer",1345,1);
        } catch (InvalidNumberException e) {
            e.printStackTrace();
        } catch (InvalidBeerException e) {
            e.printStackTrace();
        }

        BeerOrderRepository beerOrderRepository = ctx.getBean("beerOrderRepository",BeerOrderRepository.class);
        beerOrderRepository.findAll().stream().forEach(bo -> System.out.println(bo.getName()));


    }


}
