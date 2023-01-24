package be.onurbugdayci.init;

import be.onurbugdayci.jpa.UserJPA;
import be.onurbugdayci.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserImporter implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        UserJPA userJPA = new UserJPA();
        userJPA.setUsername("onur");
        userJPA.setPasswordbc(new BCryptPasswordEncoder().encode("password"));
        userRepository.save(userJPA);

    }

}
