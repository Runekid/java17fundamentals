package exercise26_04;

public class PrintApp {

    public static void main(String[] args) {
        PrintThread printThread1 = new PrintThread('a',10);
        PrintThread printThread2 = new PrintThread('b', 20);

        /*Thread thread1 = new Thread(printThread1);
        Thread thread2 = new Thread(printThread2);*/
        Thread thread1 = new Thread(() -> print('a',1000000));
        Thread thread2 = new Thread(() -> print('b',99999999));

        thread2.setDaemon(true);
        thread1.setDaemon(true);
        thread1.start();
        thread2.start();
        print('c',30);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
    public static void print(char character, int count) {
        for (int i=0;i<count;i++) {
            System.out.print(character);
            Thread.yield();
        }
    }
}
