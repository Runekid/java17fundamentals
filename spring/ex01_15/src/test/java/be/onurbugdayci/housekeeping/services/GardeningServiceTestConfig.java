package be.onurbugdayci.housekeeping.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@Import(LoggerFactory.class)
public class GardeningServiceTestConfig {
    @Bean
    public GardeningToolMock mock() {
        return new GardeningToolMock();
    }

    @Bean
    public GardeningService testCleaner() {
        return new GardeningServiceImpl();
    }
}
