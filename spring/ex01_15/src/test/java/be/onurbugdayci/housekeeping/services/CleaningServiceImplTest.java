package be.onurbugdayci.housekeeping.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=CleaningServiceTestConfig.class, properties = "rate=10")
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
