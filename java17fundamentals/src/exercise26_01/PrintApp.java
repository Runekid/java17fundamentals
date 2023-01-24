package exercise26_01;

public class PrintApp {

    public static void main(String[] args) {
        PrintThread thread1 = new PrintThread('a',10);
        PrintThread thread2 = new PrintThread('b', 20);
        thread1.start();
        thread2.start();
    }
}
