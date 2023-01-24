package be.onurbugdayci.housekeeping.services;

public class GardeningToolMock implements GardeningTool{
    private boolean gardenCalled = false;

    @Override
    public void doGardenJob() {
        gardenCalled = true;
    }

    public boolean isCalled() {
        return gardenCalled;
    }
}
