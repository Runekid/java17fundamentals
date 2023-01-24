package be.onurbugdayci.housekeeping.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(DomesticSeviceTestConfig.class)
@ActiveProfiles("smallHouse")
@DirtiesContext
public class DomesticServiceImplTest {

    @Autowired
    private DomesticService domesticService;


    @Test

    public void testDoRunHousHold() {
        domesticService.runHouseHold();
    }
}
