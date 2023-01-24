package be.onurbugdayci.housekeeping.services;

import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@Profile("bigHouse")
public class Sponge implements CleaningTool{
    @Override
    public void doCleanJob() {
        System.out.println("Hey Squidward HEHHEHEHEHEHE");
    }

    public Sponge() {
        System.out.println("sponge aangemaakt");
    }
}
