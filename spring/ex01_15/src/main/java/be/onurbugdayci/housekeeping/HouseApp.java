package be.onurbugdayci.housekeeping;

import be.onurbugdayci.housekeeping.aop.MusicMaker;
import be.onurbugdayci.housekeeping.services.DomesticService;
import be.onurbugdayci.housekeeping.services.DomesticServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
@SpringBootApplication
public class HouseApp {
    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(HouseApp.class);
        ctx.start();
    }
}
