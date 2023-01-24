package exercise07_02;

import java.util.Scanner;

public class ArrayObjApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String text = keyboard.nextLine();
        String[] textCopy = text.split(" ");
        for (String word : textCopy) {
            System.out.println(word);
        }
    }
}
