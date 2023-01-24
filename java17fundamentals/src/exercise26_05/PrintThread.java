package exercise26_05;

public class PrintThread implements Runnable{
    private char character;
    private int count;

    PrintThread(char character, int count) {
        this.character = character;
        this.count = count;
    }

    public void run() {
        for (int i=0;i<count;i++) {
            System.out.print(character);
        }
    }
}
