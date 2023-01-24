package be.onurbugdayci.housekeeping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class CleaningRobot implements CleaningService{

    private List<CleaningTool> cleaningTools;

    @Autowired
    public void setCleaningTools(List<CleaningTool> cleaningTools) {
        this.cleaningTools = cleaningTools;
    }

    @Override
    public void clean() {
        System.out.println("Robot doing cleaning");
        this.cleaningTools.forEach(CleaningTool::doCleanJob);
    }
}
