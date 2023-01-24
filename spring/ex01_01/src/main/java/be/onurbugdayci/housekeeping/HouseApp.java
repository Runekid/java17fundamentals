package be.onurbugdayci.housekeeping;

import be.onurbugdayci.housekeeping.services.*;

public class HouseApp {
    public static void main(String[] args) {
        CleaningTool broom = new Broom();
        CleaningTool vacuum = new VacuumCleaner();
        CleaningTool sponge = new Sponge();

        CleaningServiceImpl jill = new CleaningServiceImpl();
        jill.setCleaningTool(broom);
        CleaningServiceImpl bob = new CleaningServiceImpl();
        bob.setCleaningTool(vacuum);
        CleaningServiceImpl jane = new CleaningServiceImpl();
        jane.setCleaningTool(sponge);
        jill.clean();
        bob.clean();
        jane.clean();
    }
}
