package be.onurbugdayci.housekeeping.services;

public class Broom implements CleaningTool{
    @Override
    public void doCleanJob() {
        System.out.println("Scrub");
    }

    public Broom() {
        System.out.println("broom aangemaakt");
    }
}
