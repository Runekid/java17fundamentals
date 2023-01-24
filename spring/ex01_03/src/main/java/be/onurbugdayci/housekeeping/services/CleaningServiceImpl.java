package be.onurbugdayci.housekeeping.services;

public class CleaningServiceImpl implements CleaningService{
    private CleaningTool cleaningTool;

    public void setCleaningTool(CleaningTool cleaningTool) {
        this.cleaningTool = cleaningTool;
    }

    @Override
    public void clean() {
        System.out.println("Cleaning the house");
        cleaningTool.doCleanJob();
    }
}
