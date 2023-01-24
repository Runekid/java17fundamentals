package be.onurbugdayci.housekeeping.services;

public class DisposableDuster implements CleaningTool{
    private boolean used = false;

    @Override
    public void doCleanJob() {
        if (used) {
            System.out.println("Already used this duster");
        } else {
            System.out.println("Duster is being used");
            used = true;
        }
    }


}
