package be.onurbugdayci.housekeeping;

import be.onurbugdayci.gardening.GardeningService;
import be.onurbugdayci.gardening.GardeningServiceImpl;
import be.onurbugdayci.gardening.GardeningTool;
import be.onurbugdayci.gardening.LawnMower;
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
    @Primary
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

    @Bean
    public GardeningTool lawnmower() {
        return new LawnMower();
    }

    @Bean(initMethod = "init",destroyMethod = "destroy")
    @Primary
    public GardeningService gardeningService(GardeningTool gardeningTool) {
        GardeningServiceImpl service = new GardeningServiceImpl();
        service.setGardeningTool(gardeningTool);
        return service;
    }

    @Bean
    public DomesticService domesticService(CleaningService cleaningService,GardeningService gardeningService) {
        DomesticServiceImpl service = new DomesticServiceImpl();
        service.setCleaningService(cleaningService);
        service.setGardeningService(gardeningService);
        return service;
    }
}
