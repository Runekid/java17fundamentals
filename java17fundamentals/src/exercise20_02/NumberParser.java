package exercise20_02;

import java.math.BigDecimal;
@FunctionalInterface
public interface NumberParser {
    BigDecimal parse(String s);
}
