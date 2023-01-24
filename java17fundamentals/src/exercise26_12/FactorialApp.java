package exercise26_12;

import java.util.concurrent.*;

public class FactorialApp {

   public static void main(String[] args) throws Exception {
      FactorialCalculator fc = new FactorialCalculator(30);
      
      ExecutorService es = Executors.newSingleThreadExecutor();
      
      Future<Long> future = es.submit(fc);      
      
      while(!future.isDone()) {
         System.out.println("Waiting");
      }
      
      Long factorial = future.get();
      System.out.println(factorial);
      es.shutdown();
   }
}
