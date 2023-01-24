package be.onurbugdayci.housekeeping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Logger;

@Component("domesticService")
public class DomesticServiceImpl implements DomesticService{

    private Logger logger;
    private CleaningService cleaningService;
    private GardeningService gardeningService;

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
    @Autowired
    public void setCleaningService(CleaningService cleaningService) {
        this.cleaningService = cleaningService;
    }

    @Autowired
    public void setGardeningService(GardeningService gardeningService) {
        this.gardeningService = gardeningService;
    }


    @EventListener(ContextStartedEvent.class)
    @Order(1)
    public void runHouseHold() {
        logger.info("Runnning household");
        cleaningService.clean();
        gardeningService.garden();
    }

    @PostConstruct
    public void init() {
        System.out.println("Starting domestic service");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Finishing domestic service");
    }
}
