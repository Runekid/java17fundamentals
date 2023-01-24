package be.onurbugdayci.junit.exercise05;

import java.util.Objects;

public class Temperature {
    private float value;

    public Temperature(float value) {
        setValue(value);
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        if (value < -273.15) throw new InvalidTemperatureException();
        this.value = value;
    }

    public boolean isBoiling() {
        return getValue() >= 100;
    }

    public boolean isFreezing() {
        return getValue() <= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temperature that = (Temperature) o;
        return Float.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
