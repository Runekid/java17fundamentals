package exercise05_07;

import java.util.Scanner;

public class LogicOpsApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean value1, value2;

        System.out.print("value1: ");
        value1 = keyboard.nextBoolean();
        System.out.print("value2: ");
        value2 = keyboard.nextBoolean();

        System.out.println("value1 && value2: " + (value1 && value2));
        System.out.println("value1 || value2: " + (value1 || value2));
        System.out.println("!value1: " + !value1);
        System.out.println("!value2: " + !value2);

        keyboard.close();
    }
}
