package exercise12_02;

import java.time.Instant;

public class InstantApp {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(now.plusSeconds(7).plusMillis(5).plusNanos(3));
    }
}
