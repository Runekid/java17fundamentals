package be.onurbugdayci.gardening;

public class GardeningServiceImpl implements GardeningService{
    private GardeningTool gardeningTool;


    public void init() {
        System.out.println("Preparing to work");
    }

    public void destroy() {
        System.out.println("Finishing work");
    }

    public void setGardeningTool(GardeningTool gardeningTool) {
        this.gardeningTool = gardeningTool;
    }


    @Override
    public void garden() {
        System.out.println("Working in the garden");
        gardeningTool.doGardenJob();
    }
}
