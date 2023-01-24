package be.onurbugdayci.housekeeping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Profile("smallHouse")
public class CleaningServiceImpl implements CleaningService{
    private CleaningTool cleaningTool;
    private float rate;

    @Autowired
    public void setCleaningTool(CleaningTool cleaningTool) {
        this.cleaningTool = cleaningTool;
    }

    @PostConstruct
    public void init() {
        System.out.println("Starting cleaning service");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Finishing cleaning service");
    }

    @Override
    public void clean() {
        System.out.println("Cleaning the house");
        cleaningTool.doCleanJob();
    }

    @Value("${rate}")
    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getRate() {
        return rate;
    }
}
