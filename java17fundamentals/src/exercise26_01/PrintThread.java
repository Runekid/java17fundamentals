package exercise26_01;

public class PrintThread extends Thread{
    private char character;
    private int count;

    PrintThread(char character, int count) {
        this.character = character;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i=0;i<count;i++) {
            System.out.println(character);
        }
    }
}
