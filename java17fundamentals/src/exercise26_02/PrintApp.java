package exercise26_02;

public class PrintApp {

    public static void main(String[] args) {
        PrintThread printThread1 = new PrintThread('a',10);
        PrintThread printThread2 = new PrintThread('b', 20);

        /*Thread thread1 = new Thread(printThread1);
        Thread thread2 = new Thread(printThread2);*/
        Thread thread1 = new Thread(() -> print('a',10));
        Thread thread2 = new Thread(() -> print('b',20));

        thread1.start();
        thread2.start();
        print('c',30);
    }
    public static void print(char character, int count) {
        for (int i=0;i<count;i++) {
            System.out.print(character);
        }
    }
}
