package be.onurbugdayci.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebApplication {

    @Autowired
    private MyInterceptor interceptor;

    @Bean
    public WebMvcConfigurer configurer() {
        return new WebMvcConfigurer() {

            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/welcome").setViewName("welcome");
                registry.addViewController("/child")
                        .setViewName("children");
                registry.addViewController("/teenager")
                        .setViewName("teenagers");
                registry.addViewController("/adult")
                        .setViewName("adults");
                registry.addViewController("/cancel")
                        .setViewName("cancel");
                registry.addViewController("/language").setViewName(
                        "language");
                registry.addViewController("/secure").setViewName(
                        "secure");
            }

            public void addInterceptors(
                    InterceptorRegistry registry) {
                registry.addInterceptor(interceptor).addPathPatterns(
                        "/hello/*");
                registry.addInterceptor(localeChangeInterceptor());
            }

        };
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setCookieMaxAge(1000);
        // SessionLocaleResolver resolver = new
        // SessionLocaleResolver()
        return resolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("language");
        return interceptor;
    }

    @Bean
    public WebSecurityConfigurer<WebSecurity> securityConfigurer() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(
                    AuthenticationManagerBuilder auth)
                    throws Exception {
                auth.inMemoryAuthentication()
                        .passwordEncoder(new BCryptPasswordEncoder())
                        .withUser("homer")
                        .password(
                                "$2a$10$6ijNwwL19abb5t/kD2AqLeMYi8/fNuldNSSrU9h6CLHEhAWW6IB.S")
                        .roles("ADULT")
                        .and()
                        .withUser("bart")
                        .password(
                                "$2a$10$6ijNwwL19abb5t/kD2AqLeMYi8/fNuldNSSrU9h6CLHEhAWW6IB.S")
                        .roles("MINOR");
            }

            @Override
            protected void configure(HttpSecurity http)
                    throws Exception {
                //http.httpBasic();
                http.formLogin();
                http.csrf().disable();
               http.authorizeRequests()
                        .mvcMatchers("/secure/**")
                        .hasRole("ADULT"); // .hasRole("MINOR") minor won't be able to access secret because it's set to role of adult on the service method getSecret
            }
        };
    }


    public static void main(String[] args) throws Throwable {
        SpringApplication.run(WebApplication.class,args);
    }
}
