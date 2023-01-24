package exercise05_18;

import java.util.Scanner;

public class KeyboardUtility {
    public static int readInt() {
        Scanner keyboard = new Scanner(System.in);
        int value = keyboard.nextInt();
        // keyboard.close(); example showed this, but this gives a NoSuchElement error
        return value;

    }
}
