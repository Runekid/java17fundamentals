package be.onurbugdayci.housekeeping.services;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"be.onurbugdayci.housekeeping.services", "be.onurbugdayci.housekeeping.aop"}, excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "*.TestConfig.*"))
public class DomesticSeviceTestConfig {
}
