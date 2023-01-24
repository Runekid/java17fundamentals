package exercise26_10;

import java.util.Timer;
import java.util.TimerTask;

public class KlokApp {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Klok(), 0, 1000);
    }
}
