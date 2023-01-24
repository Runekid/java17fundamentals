package exercise22_02;

import java.util.*;

public class HashSetStringApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Collection<String> words = new HashSet<>();
        String word = null;
        do {
            word = keyboard.next();
            words.add(word);
        } while (!word.endsWith("."));

        for(int i=words.size()-1;i>=0;i--) {
            //System.out.println(words.get(i)); can't iterate over set with index
        }
        System.out.println(words.size());
        String[] conv = words.toArray(new String[0]);
        for (String wordd: conv) {
            System.out.println(wordd); // volgorde is willekeurig
        }
        keyboard.close();
    }
}
