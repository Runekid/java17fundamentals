package exercise26_05;

public class PrintApp {

    public static void main(String[] args) throws InterruptedException {
        PrintThread printThread1 = new PrintThread('a', 10);
        PrintThread printThread2 = new PrintThread('b', 20);

        /*Thread thread1 = new Thread(printThread1);
        Thread thread2 = new Thread(printThread2);*/
        Thread thread1 = new Thread(() -> print('a', 1000000));
        Thread thread2 = new Thread(() -> print('b', 99999999));

        thread2.setName("T1");
        thread1.setName("T2");
        thread1.start();
        thread2.start();
        print('c', 30);
        Thread.sleep(480);
        thread1.interrupt();
        Thread.sleep(200);
        thread2.interrupt();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    public static void print(char character, int count) {

        try {
            for (int i = 0; i < count; i++) {
                System.out.print(character);
                //Thread.yield(); not nexessary since we have sleep

                Thread.sleep(100);

            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " :Interrupted");
        }
    }
}
