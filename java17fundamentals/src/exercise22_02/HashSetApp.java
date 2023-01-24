package exercise22_02;

import java.util.*;

public class HashSetApp {
    public static void main(String[] args) {
        Collection<Integer> list = new HashSet<>();
        Scanner keyboard = new Scanner(System.in);
        for (int i=0;i<3;i++) {
            list.add(keyboard.nextInt());
        }

        list.forEach(System.out::println);
        System.out.println(list.stream().mapToInt(num -> num).sum());
        System.out.println(list.stream().mapToDouble(num -> num).average().getAsDouble());
        keyboard.close();
    }
}
