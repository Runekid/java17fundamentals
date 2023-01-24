package be.onurbugdayci.housekeeping.services;

public class CleaningToolMock implements CleaningTool{
    private boolean cleanCallled = false;

    @Override
    public void doCleanJob() {
        cleanCallled = true;
    }

    public boolean isCalled() {
        return cleanCallled;
    }
}
