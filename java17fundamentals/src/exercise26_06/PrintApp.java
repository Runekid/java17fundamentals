package exercise26_06;

public class PrintApp {

    public static void main(String[] args) throws InterruptedException {
        PrintThread printThread1 = new PrintThread('a', 10);
        PrintThread printThread2 = new PrintThread('b', 20);

        /*Thread thread1 = new Thread(printThread1);
        Thread thread2 = new Thread(printThread2);*/
        Thread thread1 = new Thread(() -> print('a', 100));
        Thread thread2 = new Thread(() -> print('b', 100));

        thread1.setName("T1");
        thread2.setName("T2");
        thread1.start();
        thread2.start();

        thread1.join(3000);
        if (thread1.isAlive()) {
            thread1.interrupt();
            thread1.join(10);
        }

        thread2.join(3000);
        if (thread2.isAlive()) {
            thread2.interrupt();
            thread2.join(10);
        }

        System.out.println("The end");
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
