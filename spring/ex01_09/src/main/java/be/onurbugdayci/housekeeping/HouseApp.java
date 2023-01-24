package be.onurbugdayci.housekeeping;

import be.onurbugdayci.housekeeping.services.CleaningServiceImpl;
import be.onurbugdayci.housekeeping.services.DomesticService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HouseApp {
    public static void main(String[] args) {
        //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();

        ctx.getEnvironment().setActiveProfiles("smallHouse");
        //ctx.getEnvironment().setActiveProfiles("bigHouse");

        //ctx.register(AppConfig.class);
        ctx.setConfigLocation("config.xml");
        ctx.refresh();

        System.out.println("Container started");
        DomesticService domesticService = ctx.getBean("domesticService", DomesticService.class);
        domesticService.runHouseHold();
        CleaningServiceImpl cleaningService = ctx.getBean("cleaningServiceImpl", CleaningServiceImpl.class);
        System.out.println(cleaningService.getRate());
        ctx.close();
    }
}
