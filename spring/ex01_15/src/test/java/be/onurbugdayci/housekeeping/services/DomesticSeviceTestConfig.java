package be.onurbugdayci.housekeeping.services;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration

@ComponentScan(basePackages = {"be.onurbugdayci.housekeeping.services",
        "be.onurbugdayci.housekeeping.aop"}, excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*TestConfig.*"))
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
public class DomesticSeviceTestConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setBasename("housekeeping");
        return ms;
    }
}
