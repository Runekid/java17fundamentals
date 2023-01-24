package be.onurbugdayci.repositories;

import be.onurbugdayci.jpa.UserJPA;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserJPA, Long> {
    Optional<UserJPA> findByUsernameEquals(String username);
}
