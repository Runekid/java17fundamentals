package be.onurbugdayci.housekeeping;

import be.onurbugdayci.housekeeping.services.CleaningService;
import be.onurbugdayci.housekeeping.services.CleaningServiceImpl;
import be.onurbugdayci.housekeeping.services.DomesticService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        CleaningServiceImpl cleaningService = ctx.getBean("cleaningServiceImpl", CleaningServiceImpl.class);
        System.out.println(cleaningService.getRate());
        ctx.close();
    }
}
