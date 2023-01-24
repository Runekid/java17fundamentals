package be.onurbugdayci.housekeeping.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(DomesticSeviceTestConfig.class)
public class DomesticServiceImplTest {

    @Autowired
    private DomesticService testDomesticService;


    @Test
    public void testDoRunHousHold() {
        testDomesticService.runHouseHold();
    }
}
