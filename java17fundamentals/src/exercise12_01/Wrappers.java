package exercise12_01;

import java.util.Scanner;

public class Wrappers {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.next();

        Integer value = Integer.valueOf(input);
        int intValue = Integer.parseInt(input);

        System.out.println(value);
        System.out.println(intValue);


        value += 5;

        System.out.println(value);

        System.out.println("Integer number of bits: " + Integer.SIZE);
        System.out.println("Integer number of bytes: " + Integer.BYTES);

        keyboard.close();

        Integer a1 = 127; // 8 bit values are saved in the JVM and references are equal since the same integer object is retrieved, also valid for boolean wrapper objects
        Integer a2 = 127;
        System.out.println(a1 == a2);
    }
}
