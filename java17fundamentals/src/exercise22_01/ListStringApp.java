package exercise22_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListStringApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        String word = null;
        do {
            word = keyboard.next();
            words.add(word);
        } while (!word.endsWith("."));

        for(int i=words.size()-1;i>=0;i--) {
            System.out.println(words.get(i));
        }
        System.out.println(words.size());
        String[] conv = words.toArray(new String[0]);
        for (String wordd: conv) {
            System.out.println(wordd);
        }
        keyboard.close();
    }
}
