package exercise05_11;

import java.util.Scanner;

public class ConOpsApp {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int number1,number2,number3;

        System.out.print("number1: ");
        number1 = keyboard.nextInt();
        System.out.print("number2: ");
        number2 = keyboard.nextInt();
        System.out.print("number3: ");
        number3 = keyboard.nextInt();

        System.out.println("(number1 < number2) ? number1:number2 -> " + ((number1 < number2) ? number1:number2));
        System.out.println("(number1 < number3) ? number1:number3 -> " + ((number1 < number3) ? number1:number3));
        System.out.println("(number2 < number1) ? number2:number1 -> " + ((number2 < number1) ? number2:number1));
        System.out.println("(number2 < number3) ? number2:number3 -> " + ((number2 < number3) ? number2:number3));
        System.out.println("(number3 < number1) ? number3:number1 -> " + ((number3 < number1) ? number3:number1));
        System.out.println("(number3 < number2) ? number3:number2 -> " + ((number3 < number2) ? number3:number2));


        keyboard.close();

    }
}
