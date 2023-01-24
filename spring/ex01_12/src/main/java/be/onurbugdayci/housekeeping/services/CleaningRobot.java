package be.onurbugdayci.housekeeping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
@Primary
@Profile("bigHouse")
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

    @PostConstruct
    public void init() {
        System.out.println("Starting robot cleaning service bzzzzt");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Finishing robot cleaning service bzzzt");
    }
}
