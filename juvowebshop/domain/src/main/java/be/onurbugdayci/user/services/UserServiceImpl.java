package be.onurbugdayci.user.services;

import be.onurbugdayci.jpa.ProductJPA;
import be.onurbugdayci.jpa.ProductOrderEntryJPA;
import be.onurbugdayci.jpa.UserJPA;
import be.onurbugdayci.repositories.UserRepository;
import be.onurbugdayci.user.domain.User;
import be.onurbugdayci.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public User findById(long id) {
        Optional<UserJPA> userJPA = repository.findById(id);
        if (userJPA.isPresent()) return mapper.mapToUser(userJPA.get());
        return null;
    }

    @Override
    public User findLoggedInUser() {
        return findById(getLoggedInUserId());
    }

    @Override
    public User createUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPasswordbc(new BCryptPasswordEncoder().encode(password));
        UserJPA userJPA = repository.save(mapper.mapToUserJPA(user));
        return mapper.mapToUser(userJPA);
    }

    @Override
    public User findByUsername(String username) {
        Optional<UserJPA> userJPA = repository.findByUsernameEquals(username);
        if (userJPA.isPresent()) return mapper.mapToUser(userJPA.get());
        return null;
    }

    public Long getLoggedInUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails userdetails) {
            return findByUsername(userdetails.getUsername()).getId();
        }
        return null;

    }
}
