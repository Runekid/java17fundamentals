package be.onurbugdayci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.sql.DataSource;
import java.util.Locale;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebApplication {



    @Autowired
    public void configureSecurity(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
        auth.jdbcAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select username,passwordbc,true from User where username = ?")
                .authoritiesByUsernameQuery("select username,'Adult' from User where username = ?");
    }

    @Bean
    public SecurityFilterChain configureSecurityFilterChain(HttpSecurity http)
            throws Exception {

        //http.httpBasic();
        http.formLogin()
                .loginPage("/myLogin")
                .and()
                .csrf()
                .disable();
        http.authorizeRequests()
                .mvcMatchers("/cart")
                .authenticated();
        return http.build();

    }



    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(WebApplication.class, args);
    }
}
