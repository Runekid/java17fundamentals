package be.onurbugdayci.housekeeping.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("smallHouse")
public class LawnMower implements GardeningTool{
    @Override
    public void doGardenJob() {
        System.out.println("Mowing");
    }
}
