package exercise05_16;

import java.io.IOException;
import java.util.Scanner;

public class WhileApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        /*int num1 = 120;
        while (num1 >= 100) {
            System.out.println(num1--);
        }*/

       /* int num2 = 3;
        while (num2 < 50) {
            System.out.println(num2);
            num2 += 3;
        } */

       /* int num3 = 1;
        while (num3 < 10000) {
            System.out.println(num3);
            num3 *= 5;
        } */

       /* char aChar = 'A';
        do {
            System.out.println(aChar++);

        }
        while (aChar <= 'Z'); */

        int num4;
        do {
            System.out.print("Give a number between 1 and 10: ");
            num4 = keyboard.nextInt();
        }
        while (num4 < 1 || num4 > 10);

        keyboard.close();
    }
}
