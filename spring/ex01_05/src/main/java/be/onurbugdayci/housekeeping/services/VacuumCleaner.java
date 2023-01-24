package be.onurbugdayci.housekeeping.services;

import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class VacuumCleaner implements CleaningTool{
    @Override
    public void doCleanJob() {
        System.out.println("SIUUUUU");
    }

    public VacuumCleaner() {
        System.out.println("Vacuum aangemaakt");
    }
}
