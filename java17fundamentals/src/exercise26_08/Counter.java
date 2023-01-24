package exercise26_08;

public class Counter {
    private int counter = 0;

    public synchronized void incerement() {
        counter++;
    }

    public synchronized void decrement() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }
}
