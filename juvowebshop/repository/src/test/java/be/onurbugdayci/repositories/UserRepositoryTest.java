package be.onurbugdayci.repositories;

import be.onurbugdayci.jpa.UserJPA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    @Sql("/sql/userRepository/findByUsernameEquals.sql")
    void findByUsernameEquals() {
        Optional<UserJPA> userJPA = repository.findByUsernameEquals("findme");
        assertTrue(userJPA.isPresent());
        assertEquals("findme",userJPA.get().getUsername());
    }
}