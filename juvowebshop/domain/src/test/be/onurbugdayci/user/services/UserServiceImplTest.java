package be.onurbugdayci.user.services;

import be.onurbugdayci.jpa.UserJPA;
import be.onurbugdayci.repositories.UserRepository;
import be.onurbugdayci.user.domain.User;
import be.onurbugdayci.user.mapper.UserMapper;
import be.onurbugdayci.user.mapper.UserMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {UserServiceImpl.class,UserMapperImpl.class})
class UserServiceImplTest {

    @Autowired
    private UserService service;

    @MockBean
    private Authentication authentication;
    @MockBean
    private SecurityContext securityContext;

    @MockBean
    private UserRepository repository;

    @Test
    void testCreateUser() {
        Mockito.when(repository.save(ArgumentMatchers.any())).then(invocationOnMock -> invocationOnMock.getArgument(0));
        User user = service.createUser("test", "password");
        assertEquals("test", user.getUsername());
        assertTrue(new BCryptPasswordEncoder().matches("password", user.getPasswordbc()));
    }

    @Test
    void testFindById() {
        UserJPA userJPA = UserFixture.getUserJPA();

        Mockito.when(repository.findById(userJPA.getId())).thenReturn(Optional.of(userJPA));

        assertNotNull(service.findById(userJPA.getId()));
        User user = service.findById(userJPA.getId());
        assertEquals(userJPA.getId(), user.getId());
        assertEquals(userJPA.getUsername(), user.getUsername());
        assertEquals(userJPA.getPasswordbc(), user.getPasswordbc());
    }

    @Test
    void testFindByUsername() {
        UserJPA userJPA = UserFixture.getUserJPA();

        Mockito.when(repository.findByUsernameEquals(userJPA.getUsername())).thenReturn(Optional.of(userJPA));

        assertNotNull(service.findByUsername(userJPA.getUsername()));
        User user = service.findByUsername(userJPA.getUsername());
        assertEquals(userJPA.getId(), user.getId());
        assertEquals(userJPA.getUsername(), user.getUsername());
        assertEquals(userJPA.getPasswordbc(), user.getPasswordbc());
    }

    @Test
    void testGetLoggedInUserId() {
        UserJPA userJPA = UserFixture.getUserJPA();
        Collection authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("TEST"));
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        Mockito.when(authentication.getPrincipal()).thenReturn(new org.springframework.security.core.userdetails.User("test", "test", authorities));
        Mockito.when(repository.findByUsernameEquals(userJPA.getUsername())).thenReturn(Optional.of(userJPA));



        long id = service.getLoggedInUserId();
        assertEquals(userJPA.getId(),id);
    }


    @Test
    void testFindLoggedInUser() {
        UserJPA userJPA = UserFixture.getUserJPA();

        Collection authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("TEST"));
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        Mockito.when(authentication.getPrincipal()).thenReturn(new org.springframework.security.core.userdetails.User("test", "password", authorities));
        Mockito.when(repository.findByUsernameEquals(userJPA.getUsername())).thenReturn(Optional.of(userJPA));
        Mockito.when(repository.findById(userJPA.getId())).thenReturn(Optional.of(userJPA));

        assertNotNull(service.findLoggedInUser());
        User user = service.findLoggedInUser();
        assertEquals(userJPA.getId(), user.getId());
        assertEquals(userJPA.getUsername(), user.getUsername());
        assertEquals(userJPA.getPasswordbc(), user.getPasswordbc());
    }
}