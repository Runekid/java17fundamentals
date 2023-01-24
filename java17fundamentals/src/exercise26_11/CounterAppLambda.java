package exercise26_11;

public class CounterAppLambda {
   public static void main(String[] args) throws Exception {
      Counter counter = new Counter();
      Thread thread1 = new Thread(() -> increment(counter, 10000));
      Thread thread2 = new Thread(() -> increment(counter, 10000));
      Thread thread3 = new Thread(() -> decrement(counter, 10000));
      Thread thread4 = new Thread(() -> decrement(counter, 10000));

      thread1.start();
      thread2.start();
      thread3.start();
      thread4.start();

      thread1.join();
      thread2.join();
      thread3.join();
      thread4.join();

      System.out.println(counter.getCount());
   }

   public static void increment(Counter counter, int number) {
      for (int i = 0; i < number; i++) {
         counter.increment();
      }
   }
   
   public static void decrement(Counter counter, int number) {
      for (int i = 0; i < number; i++) {
         counter.decrement();
      }
   }
}
