package be.onurbugdayci.housekeeping;

import be.onurbugdayci.housekeeping.services.DomesticService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("smallHouse");
        //ctx.getEnvironment().setActiveProfiles("bigHouse");

        ctx.register(AppConfig.class);
        ctx.refresh();

        System.out.println("Container started");
        DomesticService domesticService = ctx.getBean("domesticService", DomesticService.class);
        domesticService.runHouseHold();
        ctx.close();
    }
}
