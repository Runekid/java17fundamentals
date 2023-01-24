package be.onurbugdayci.beers;

import be.onurbugdayci.beers.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@SpringBootApplication//(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
@EnableGlobalMethodSecurity(securedEnabled = true)
public class BeerApp {
    @Bean
    public WebSecurityConfigurer<WebSecurity> securityConfigurer( DataSource ds) {
        return new WebSecurityConfigurerAdapter() {

            @Override
            protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.inMemoryAuthentication()
                        .passwordEncoder(new BCryptPasswordEncoder())
                        .withUser("user")
                        .password("$2a$12$ggZsFJl1C4wGuUXiKqqyZ.vNBsuDiSiId1gqkHdYwmDVhDtvJpIZ.")
                        .roles("ADULT")
                        .and()
                        .withUser("bart")
                        .password("$2a$10$6ijNwwL19abb5t/kD2AqLeMYi8/fNuldNSSrU9h6CLHEhAWW6IB.S")
                        .roles("MINOR");
            }

            @Override
            protected void configure(HttpSecurity http)
                    throws Exception {
                http.csrf().disable();
                http.httpBasic();
                http.authorizeRequests()
                        .antMatchers("/orders/**")
                        .hasRole("ADULT");
            }
        };
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(BeerApp.class, args);

        /*SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = new UsernamePasswordAuthenticationToken("user","password");
        securityContext.setAuthentication(authentication);*/


    }


}
