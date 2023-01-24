package be.onurbugdayci.housekeeping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CleaningServiceImpl implements CleaningService{
    private CleaningTool cleaningTool;
    private float rate;

    @Autowired
    public void setCleaningTool(CleaningTool cleaningTool) {
        this.cleaningTool = cleaningTool;
    }

    @Override
    public void clean() {
        System.out.println("Cleaning the house");
        cleaningTool.doCleanJob();
    }

    @Value("9")
    public void setRate(float rate) {
        this.rate = rate;
    }
}
