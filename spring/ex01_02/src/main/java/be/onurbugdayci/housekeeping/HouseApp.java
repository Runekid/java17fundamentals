package be.onurbugdayci.housekeeping;

import be.onurbugdayci.housekeeping.services.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        CleaningService jill = ctx.getBean("jill", CleaningService.class);
        CleaningService bob = ctx.getBean("bob", CleaningService.class);
        CleaningService onur = ctx.getBean("onur", CleaningService.class);
        jill.clean();
        bob.clean();
        onur.clean();
        ctx.close();
    }
}
