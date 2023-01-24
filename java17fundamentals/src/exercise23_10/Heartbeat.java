package exercise23_10;

import java.util.TimerTask;

public class Heartbeat extends TimerTask {
    @Override
    public void run() {
        System.out.println("*");
    }
}
