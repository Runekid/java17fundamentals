package exercise06_03;

import java.util.Locale;
import java.util.Scanner;

public class StringApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String text = keyboard.next();

        System.out.println(text);
        System.out.println(text.length());

        System.out.println(text.toUpperCase());
        System.out.println(text.toLowerCase());
        System.out.println(text.replace('a','o'));
        int count = 0;
        for (int i=0;i<text.length();i++) {
            if (text.charAt(i) == 'e') count++;
        }
        System.out.println(count);

        String text2 = "another string";
        System.out.println(text.equals(text2));
        System.out.println(text.compareTo(text2) <= 0 ? text: text2);
        String text3 = "                             toomanyspaces                            ";
        System.out.println(text3.trim());

        keyboard.close();


    }
}
