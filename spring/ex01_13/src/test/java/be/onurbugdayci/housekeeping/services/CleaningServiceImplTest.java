package be.onurbugdayci.housekeeping.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitConfig(CleaningServiceTestConfig.class)
public class CleaningServiceImplTest {

    @Autowired
    private CleaningService testCleaner;
    @Autowired
    private CleaningToolMock mock;

    @Test
    public void testDoJob() {
        testCleaner.clean();
        assertTrue(mock.isCalled());
    }

}
