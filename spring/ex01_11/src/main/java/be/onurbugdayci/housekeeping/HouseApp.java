package be.onurbugdayci.housekeeping;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp {
    public static void main(String[] args) {
        /*AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        //ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();

        ctx.getEnvironment().setActiveProfiles("smallHouse");
        //ctx.getEnvironment().setActiveProfiles("bigHouse");

        ctx.register(AppConfig.class);
        //ctx.setConfigLocation("config.xml");

        ctx.refresh();
        ctx.start();

        *//*System.out.println("Container started");
        DomesticService domesticService = ctx.getBean("domesticService", DomesticService.class);
        domesticService.runHouseHold();
        CleaningServiceImpl cleaningService = ctx.getBean("cleaningServiceImpl", CleaningServiceImpl.class);
        System.out.println(cleaningService.getRate());
        //ctx.publishEvent(new LunchEvent());
        //Cook cook = ctx.getBean("cook", Cook.class);
       //cook.makeLunch();*//*
        ctx.close();*/

        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
            ctx.getEnvironment().setActiveProfiles("smallHouse");
            ctx.register(AppConfig.class);
            ctx.refresh();
            ctx.start();
        }
    }
}
