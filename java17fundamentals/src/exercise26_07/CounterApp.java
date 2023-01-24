package exercise26_07;

public class CounterApp {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> increment(counter, 10000));
        Thread thread2 = new Thread(() -> increment(counter, 10000));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(counter.getCounter());

    }
    public static void increment(Counter counter, int number) {
        for (int i=0;i<number;i++) {
            counter.incerement();
        }
    }
}
