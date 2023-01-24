package exercise22_01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListApp {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
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
