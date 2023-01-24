package exercise26_05;

import java.util.stream.IntStream;

public class TimeBomb extends Thread {

    private int time;
    private boolean active = false;

    public TimeBomb(int time) {
        this.time = time;
        setDaemon(true);
    }

    public void activate() {
        start();
        active = true;
    }

    public void disarm() {
        interrupt();
        active = false;
    }

    @Override
    public void run() {
        while (active && (time > 0)) {
            try {
                Thread.sleep(1000);
                System.out.format("Timebomb ticking: %d seconds left\n",
                        --time);
            } catch (InterruptedException e) {
                active = false;
            }
        }
        if(active) {
            System.out.println("Boooooom!!!");
        } else {
            System.out.println("Disarmed!!!");
        }
    }
}
