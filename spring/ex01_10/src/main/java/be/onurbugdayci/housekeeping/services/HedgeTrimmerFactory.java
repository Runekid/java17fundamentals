package be.onurbugdayci.housekeeping.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class HedgeTrimmerFactory {
    @Bean
    @Primary
    @Profile("bigHouse")
    public GardeningTool hedgeTrimmer() {
        int hour = LocalTime.now().getHour();
        if (hour > 8 && hour < 18) {
            return () -> System.out.println("Trimming electric");
        } else {
            return () -> System.out.println("Trimming manual");
        }
    }
}
