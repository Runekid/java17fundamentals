package be.onurbugdayci.housekeeping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GardeningServiceImpl implements GardeningService{


    private GardeningTool gardeningTool;

    @PostConstruct
    public void init() {
        System.out.println("Preparing to work");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Finishing work");
    }

    @Autowired
    public void setGardeningTool(GardeningTool gardeningTool) {
        this.gardeningTool = gardeningTool;
    }


    @Override
    public void garden() {
        System.out.println("Working in the garden");
        gardeningTool.doGardenJob();
    }
}
