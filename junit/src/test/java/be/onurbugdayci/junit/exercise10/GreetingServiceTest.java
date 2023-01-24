package be.onurbugdayci.junit.exercise10;

import be.onurbugdayci.junit.exercise09.GreetingService;
import be.onurbugdayci.junit.exercise09.Hello;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class GreetingServiceTest {
    @InjectMocks
    private GreetingService greeting;

    @Mock
    private Hello helloMock;

    @Test
    public void testGreet() {
        //prepare mock
        Mockito.when(helloMock.sayHello("World")).thenReturn("Hello World");
        //execute test
        String answer = greeting.greet("World");
        assertEquals("Greeting message: Hello World", answer);
    }
}
