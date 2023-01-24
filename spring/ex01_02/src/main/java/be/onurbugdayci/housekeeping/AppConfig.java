package be.onurbugdayci.housekeeping;

import be.onurbugdayci.housekeeping.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CleaningTool broom() {
        return new Broom();
    }

    @Bean
    public CleaningTool vacuum() {
        return new VacuumCleaner();
    }

    @Bean
    public CleaningTool sponge() {
        return new Sponge();
    }

    @Bean
    public CleaningService jill() {
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(broom());
        return cs;
    }

    @Bean
    public CleaningService bob() {
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(vacuum());
        return cs;
    }

    @Bean
    public CleaningService onur() {
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(sponge());
        return cs;
    }
}
