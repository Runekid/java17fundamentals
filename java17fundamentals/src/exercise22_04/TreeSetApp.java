package exercise22_04;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class TreeSetApp {
    public static void main(String[] args) {
        NavigableSet<String> words = new TreeSet<>();
        Scanner keyboard = new Scanner(System.in);
        while(words.size()<3) {
            words.add(keyboard.next());
        }
        System.out.println("list of all words");
        words.forEach(System.out::println);
        System.out.println("last alphabetical word");
        System.out.println(words.last());
        System.out.println("first alphabetical word");
        System.out.println(words.first());
        // duplicates aren't added
    }
}
