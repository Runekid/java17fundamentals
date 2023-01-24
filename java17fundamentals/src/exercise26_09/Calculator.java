package exercise26_09;

public class Calculator {
   private int value = 0;
   private int result = 0;
   private boolean done = true;
   private boolean busy = false;
   private Thread t;

   public Calculator() {
      Thread thread = new Thread(() -> calculate());
      thread.setDaemon(true);
      thread.start();
   }

   public synchronized void setValue(int value) {
      while (busy) {
         try {
            wait();
         } catch (InterruptedException e) {}
      }
      this.value = value;
      done = false;
      busy = true;
      t = Thread.currentThread();
      notifyAll();
   }

   public synchronized int getResult() {
      if (Thread.currentThread() != t) {
         throw new IllegalStateException("Wrong thread");
      }
      while (!done) { // Wait for calculation
         try {
            wait();
         } catch (InterruptedException e) {}
      }
      t = null;
      busy = false;
      notifyAll();
      return result;
   }

   private synchronized void calculate() {
      while (true) { // Infinite loop
         while (done) { // Wait for something to be calculated
            try {
               wait();
            } catch (InterruptedException e) {}
         }
         result = value * value; // Calculate result
         done = true;
         notifyAll();
      }
   }
}
