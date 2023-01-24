package be.onurbugdayci.housekeeping;

import be.onurbugdayci.housekeeping.services.*;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {
    @Bean
    @Scope("prototype")
    public CleaningTool broom() {
        return new Broom();
    }

    @Bean
    @Scope("prototype")
    public CleaningTool vacuum() {
        return new VacuumCleaner();
    }

    @Bean
    @Scope("prototype")
    public CleaningTool sponge() {
        return new Sponge();
    }

    @Bean
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.INTERFACES)
    public CleaningTool duster() {
        return new DisposableDuster();
    }

    @Bean(name = "p1")
    @Lazy
    public CleaningService jill() {
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(broom());
        return cs;
    }

    @Bean(name = "p2")
    @Lazy
    public CleaningService bob() {
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(vacuum());
        return cs;
    }

    @Bean(name = "p3")
    @Lazy
    public CleaningService onur() {
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(sponge());
        return cs;
    }

    @Bean(name = "p4")
    @Lazy
    public CleaningService runo() {
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(duster());
        return cs;
    }
}
