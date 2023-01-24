package be.onurbugdayci.housekeeping;

import be.onurbugdayci.housekeeping.services.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        CleaningService jill = ctx.getBean("p1", CleaningService.class);
        CleaningService bob = ctx.getBean("p2", CleaningService.class);
        CleaningService onur = ctx.getBean("p3", CleaningService.class);
        CleaningService runo = ctx.getBean("p4", CleaningService.class);

        jill.clean();
        bob.clean();
        onur.clean();

        runo.clean();
        runo.clean(); // new duster is created because of proxy on duster bean
        ctx.close();
    }
}
