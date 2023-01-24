package be.onurbugdayci.housekeeping.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Primary
@Order(1)
@Profile("smallHouse")
public class Broom implements CleaningTool{
    @Override
    public void doCleanJob() {
        System.out.println("Scrub");
    }

    public Broom() {
        System.out.println("broom aangemaakt");
    }
}
