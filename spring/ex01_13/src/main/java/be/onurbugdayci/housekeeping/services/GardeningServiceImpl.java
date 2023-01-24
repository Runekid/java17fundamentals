package be.onurbugdayci.housekeeping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy
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

    @EventListener
    @Order(2)
    public void onLunchEvent(LunchEvent event) {
        System.out.println("Taking a lunch break from gardening");
    }
    @Override
    public void garden() {
        System.out.println("Working in the garden");
        gardeningTool.doGardenJob();
    }


}
