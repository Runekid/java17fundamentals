package be.onurbugdayci.housekeeping;

import be.onurbugdayci.gardening.GardeningService;
import be.onurbugdayci.housekeeping.services.CleaningService;

public class DomesticServiceImpl implements DomesticService{

    private CleaningService cleaningService;
    private GardeningService gardeningService;

    public void setCleaningService(CleaningService cleaningService) {
        this.cleaningService = cleaningService;
    }

    public void setGardeningService(GardeningService gardeningService) {
        this.gardeningService = gardeningService;
    }

    @Override
    public void runHouseHold() {
        cleaningService.clean();
        gardeningService.garden();
    }
}
