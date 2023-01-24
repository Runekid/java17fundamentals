package exercise05_10;

import java.util.Scanner;

public class AssOpsApp {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int number1, number2;
        System.out.print("number1: ");
        number1 = keyboard.nextInt();
        System.out.print("number2: ");
        number2 = keyboard.nextInt();

        number1 += number2;
        System.out.println("number1 += number2 -> number1: " + number1);
        number1 -= number2;
        System.out.println("number1 -= number2 -> number1: " + number1);
        number1 *= number2;
        System.out.println("number1 *= number2 -> number1: " + number1);
        number1 /= number2;
        System.out.println("number1 /= number2 -> number1: " + number1);
        number1 %= number2;
        System.out.println("number1 %= number2 -> number1: " + number1);
        number1 &= number2;
        System.out.println("number1 +&= number2 -> number1: " + number1);
        number1 |= number2;
        System.out.println("number1 |= number2 -> number1: " + number1);
        number1 ^= number2;
        System.out.println("number1 ^= number2 -> number1: " + number1);
        number1 >>= number2;
        System.out.println("number1 >>= number2 -> number1: " + number1);
        number1 <<= number2;
        System.out.println("number1 <<= number2 -> number1: " + number1);
        number1 >>>= number2;
        System.out.println("number1 >>>= number2 -> number1: " + number1);


        keyboard.close();
    }
}
