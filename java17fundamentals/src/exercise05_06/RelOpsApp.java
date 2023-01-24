package exercise05_06;

import java.util.Scanner;

public class RelOpsApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int number1, number2;

        System.out.print("Number1: ");
        number1 = keyboard.nextInt();
        System.out.print("Number2: ");
        number2 = keyboard.nextInt();

        System.out.println("number1 < number2: " + (number1 < number2));
        System.out.println("number1 <= number2: " + (number1 <= number2));
        System.out.println("number1 > number2: " + (number1 > number2));
        System.out.println("number1 >= number2: " + (number1 >= number2));
        System.out.println("number1 == number2: " + (number1 == number2));
        System.out.println("number1 != number2: " + (number1 != number2));

        keyboard.close();

    }
}
