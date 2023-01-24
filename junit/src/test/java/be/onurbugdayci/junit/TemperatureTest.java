package be.onurbugdayci.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TemperatureTest {
    Temperature t;

    @BeforeEach
    public void init() {
        t = new Temperature(0);
    }

    @Test
    @DisplayName("Test for checking the constructor value is correctly set")
    public void testConstructor() {
        Temperature temperature = new Temperature(50);
        Assertions.assertEquals(50F, temperature.getValue());
    }

    @Test
    @DisplayName("Test for checking the getter and setter of value")
    public void testValue() {
        Temperature temperature = new Temperature(50);
        temperature.setValue(30);
        Assertions.assertEquals(30F, temperature.getValue());
    }

    @Test
    @DisplayName("Check for equals method")
    public void testEquals() {
        Temperature temperature1 = new Temperature(60);
        Temperature temperature2 = new Temperature(60);
        Assertions.assertTrue(temperature1.equals(temperature2));
    }

    @Test
    @DisplayName("Check for hashcode method")
    public void testHashcode() {
        Temperature temperature1 = new Temperature(60);
        Temperature temperature2 = new Temperature(60);
        Assertions.assertEquals(temperature1.hashCode(), temperature2.hashCode());
    }

    @Test
    public void testBoiling() {
        Assertions.assertFalse(t.isBoiling());
        t.setValue(100);
        Assertions.assertTrue(t.isBoiling());
        t.setValue(101);
        Assertions.assertTrue(t.isBoiling());
        t.setValue(99);
        Assertions.assertFalse(t.isBoiling());
    }

    @Test
    public void testFreezing() {
        Assertions.assertTrue(t.isFreezing());
        t.setValue(1);
        Assertions.assertFalse(t.isFreezing());
        t.setValue(-1);
        Assertions.assertTrue(t.isFreezing());
    }

    @Test
    public void testInvalidTemperatureException() {
        Assertions.assertThrows(InvalidTemperatureException.class, () -> t.setValue(-274));
        Assertions.assertDoesNotThrow(() -> t.setValue(-273.15F));
        Assertions.assertDoesNotThrow(() -> t.setValue(-273));
    }

    @Test
    public void testConstructorInvalidTemperatureException() {
        Assertions.assertThrows(InvalidTemperatureException.class, () -> new Temperature(-274));
        Assertions.assertDoesNotThrow(() -> new Temperature(-273.15F));
        Assertions.assertDoesNotThrow(() -> new Temperature(-273));
    }


}
