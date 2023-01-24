package be.onurbugdayci.junit.exercise12;
public class GreetingService {
   private Hello hello;

   public GreetingService(Hello hello) {
      this.hello = hello;
   }

   public String greet(String name) {
      return "Greeting message: " + hello.sayHello(name);
   }
}
