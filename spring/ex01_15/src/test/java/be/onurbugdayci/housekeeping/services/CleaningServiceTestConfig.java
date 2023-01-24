package be.onurbugdayci.housekeeping.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@Import(LoggerFactory.class)
public class CleaningServiceTestConfig {

    @Bean
    public CleaningToolMock mock() {
        return new CleaningToolMock();
    }

    @Bean
    public CleaningService testCleaner() {
        return new CleaningServiceImpl();
    }
}
