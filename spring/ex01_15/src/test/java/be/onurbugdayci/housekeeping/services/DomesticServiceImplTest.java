package be.onurbugdayci.housekeeping.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=DomesticSeviceTestConfig.class, properties = "rate=10")
@ActiveProfiles("smallHouse")
@DirtiesContext
public class DomesticServiceImplTest {

    @Autowired
    private DomesticService domesticService;


    @Test

    public void testDoRunHouseHold() {
        domesticService.runHouseHold();
    }
}
