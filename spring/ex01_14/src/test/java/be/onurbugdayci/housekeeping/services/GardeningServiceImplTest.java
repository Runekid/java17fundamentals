package be.onurbugdayci.housekeeping.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitConfig(GardeningServiceTestConfig.class)
public class GardeningServiceImplTest {
    @Autowired
    private GardeningService testGardener;
    @Autowired
    private GardeningToolMock mock;

    @Test
    public void testDoJob() {
        testGardener.garden();
        assertTrue(mock.isCalled());
    }
}
