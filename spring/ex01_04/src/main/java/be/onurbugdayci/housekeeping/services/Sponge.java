package be.onurbugdayci.housekeeping.services;

public class Sponge implements CleaningTool{
    @Override
    public void doCleanJob() {
        System.out.println("Hey Squidward HEHHEHEHEHEHE");
    }

    public Sponge() {
        System.out.println("sponge aangemaakt");
    }
}
