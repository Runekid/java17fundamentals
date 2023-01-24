package be.onurbugdayci.housekeeping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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

    @Override
    public void runHouseHold() {
        logger.info("Runnning household");
        cleaningService.clean();
        gardeningService.garden();
    }
}
