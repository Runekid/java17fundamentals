package be.onurbugdayci.gardening;

public class LawnMower implements GardeningTool{
    @Override
    public void doGardenJob() {
        System.out.println("Mowing");
    }
}
