package be.onurbugdayci.housekeeping.services;

public class VacuumCleaner implements CleaningTool{
    @Override
    public void doCleanJob() {
        System.out.println("SIUUUUU");
    }

    public VacuumCleaner() {
        System.out.println("Vacuum aangemaakt");
    }
}
