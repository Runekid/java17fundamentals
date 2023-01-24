package be.onurbugdayci.housekeeping;

import be.onurbugdayci.housekeeping.services.DomesticService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Container started");
        DomesticService domesticService = ctx.getBean("domesticService", DomesticService.class);
        domesticService.runHouseHold();
        ctx.close();
    }
}
