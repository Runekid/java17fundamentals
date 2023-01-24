package exercise26_05;

import java.sql.Time;
import java.util.Random;

public class JamesBondApp {
    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        TimeBomb timeBomb = new TimeBomb(10);
        timeBomb.activate();
        Thread.sleep(rand.nextInt(30000));
        timeBomb.disarm();
    }
}
