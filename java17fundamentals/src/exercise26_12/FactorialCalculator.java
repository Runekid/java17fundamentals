package exercise26_12;

import java.util.concurrent.*;

public class FactorialCalculator implements Callable<Long> {
   private long number;

   public FactorialCalculator(long number) {
      this.number = number;
   }

   @Override
   public Long call() throws Exception {
      if (number <= 0) {
         throw new Exception("Negative value");
      }
      long factorial = 1;
      for (long i=1; i <= number; i++) {
         factorial *= i;
      }
      return factorial;
   }
}
