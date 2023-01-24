package be.onurbugdayci.housekeeping.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class LawnMower implements GardeningTool{
    @Override
    public void doGardenJob() {
        System.out.println("Mowing");
    }
}
