package be.onurbugdayci.junit.exercise12;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

@ExtendWith(MockitoExtension.class)
public class GreetingServiceTest {
   @Mock
   private Hello helloMock;
   @InjectMocks
   private GreetingService greeting;

   @Test
   public void testGreet() {
      // prepare mock
      Mockito.when(helloMock.sayHello("World"))
            .thenReturn("Hello World");
      // execute test
      String answer = greeting.greet("World");
      Assertions.assertEquals("Greeting message: Hello World",
            answer);
   }

   @Test
   public void testGreetNull() {
      // prepare mock
      Mockito.when(helloMock.sayHello(null)).thenThrow(
            new NullPointerException());
      // execute test
      Assertions.assertThrows(NullPointerException.class,
            () -> greeting.greet(null));
   }

   @Test
   public void testGreetAnswer() {
      // prepare mock
      Mockito.when(helloMock.sayHello("World"))
            .then(new Answer<String>() {
               public String answer(
                     InvocationOnMock invocation) {
                  String arg = invocation.getArgument(0);
                  return "Hello " + arg;
               }
            });

      // execute test
      String answer = greeting.greet("World");
      Assertions.assertEquals("Greeting message: Hello World",
            answer);
   }

   @Test
   public void testGreetAnswerLambda() {
      // prepare mock
      Mockito.when(helloMock.sayHello("World"))
            .then(inv -> "Hello " + inv.getArgument(0));

      // execute test
      String answer = greeting.greet("World");
      Assertions.assertEquals("Greeting message: Hello World",
            answer);
   }

   @Test
   public void testGreetMultiple() {
      // prepare mock
      Mockito.when(helloMock.sayHello("World"))
            .thenReturn("Hello World", "Goodbye World");
      // execute test
      String answer = greeting.greet("World");
      Assertions.assertEquals("Greeting message: Hello World",
            answer);
      answer = greeting.greet("World");
      Assertions.assertEquals("Greeting message: Goodbye World",
            answer);
   }

   @Test
   public void testGreetMatcher() {
      // prepare mock
      Mockito.when(helloMock.sayHello(ArgumentMatchers.any()))
            .then(new Answer<String>() {
               public String answer(
                     InvocationOnMock invocation) {
                  String arg = invocation.getArgument(0);
                  return "Hello " + arg;
               }
            });

      // execute test
      String answer = greeting.greet("Homer");
      Assertions.assertEquals("Greeting message: Hello Homer",
            answer);
   }

   @Test
   public void testGreetVoid() {
      // prepare mock
      Mockito.doThrow(NullPointerException.class).when(helloMock)
            .sayHello(null);

      // execute test
      Assertions.assertThrows(NullPointerException.class,
            () -> greeting.greet(null));
   }

   @Test
   public void testGreetVerify() {
      // prepare mock
      Mockito.when(helloMock.sayHello("World"))
            .thenReturn("Hello World");
      // execute test
      greeting.greet("World");
      // verify mock
      Mockito.verify(helloMock).sayHello("World");
   }

   @Test
   public void testGreetVerifyTime() {
      // prepare mock
      Mockito.when(helloMock.sayHello("World"))
            .thenReturn("Hello World");
      // execute test
      greeting.greet("World");
      // verify mock
      Mockito.verify(helloMock, Mockito.timeout(10))
            .sayHello("World");
   }

   @Test
   public void testGreetVerifyOrder() {
      // prepare mock
      Mockito.when(helloMock.sayHello("World"))
            .thenReturn("Hello World");
      // execute test
      greeting.greet("World");
      greeting.greet("Mars");
      // verify mock
      InOrder inOrder = Mockito.inOrder(helloMock);
      inOrder.verify(helloMock).sayHello("World");
      inOrder.verify(helloMock).sayHello("Mars");
   }

}
