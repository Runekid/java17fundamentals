package be.onurbugdayci.housekeeping;

import be.onurbugdayci.housekeeping.services.CleaningService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        DomesticService domesticService = ctx.getBean("domesticService", DomesticService.class);
        domesticService.runHouseHold();
        ctx.close();
    }
}
