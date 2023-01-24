package exercise22_02;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoApp {
    public static void main(String[] args) {
        Set<Integer> lottoNumbers = new HashSet<>();
        Scanner keyboard = new Scanner(System.in);
        while (lottoNumbers.size() != 6) {
            int number = keyboard.nextInt();
            if (number >= 1 && number <= 45) {
                lottoNumbers.add(number);
            } else {
                System.out.println("Pick a number between 1 and 45");
                continue;
            }
        }
        Set<Integer> winners = new HashSet<>();
        Random rand = new Random();
        while(winners.size() < 6) {
            winners.add(rand.nextInt(0,46));
        }

        lottoNumbers.retainAll(winners);
        System.out.println("matching numbers");
        lottoNumbers.forEach(System.out::println);
        System.out.println("winning numbers");
        winners.forEach(System.out::println);
        keyboard.close();
    }
}
