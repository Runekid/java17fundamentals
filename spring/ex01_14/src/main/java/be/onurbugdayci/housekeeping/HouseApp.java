package be.onurbugdayci.housekeeping;

import be.onurbugdayci.housekeeping.aop.MusicMaker;
import be.onurbugdayci.housekeeping.services.DomesticService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp {
    public static void main(String[] args) {

        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
            ctx.getEnvironment().setActiveProfiles("smallHouse");
            ctx.register(AppConfig.class);
            ctx.refresh();
            ctx.start();

            DomesticService domesticService = ctx.getBean("domesticService", DomesticService.class);
            ((MusicMaker) domesticService).makeMusic();


        }
    }
}
