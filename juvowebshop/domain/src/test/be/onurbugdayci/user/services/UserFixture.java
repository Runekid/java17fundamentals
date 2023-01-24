package be.onurbugdayci.user.services;

import be.onurbugdayci.jpa.UserJPA;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserFixture {
    public static UserJPA getUserJPA() {
        UserJPA userJPA = new UserJPA();
        userJPA.setId(1L);
        userJPA.setUsername("test");
        userJPA.setPasswordbc(new BCryptPasswordEncoder().encode("password"));
        return userJPA;
    }
}
