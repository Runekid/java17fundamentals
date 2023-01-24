package exercise22_03;

import java.util.*;

public class LottoApp {
    public static void main(String[] args) {
        Set<Integer> lottoNumbers = new LinkedHashSet<>();
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
        lottoNumbers.forEach(System.out::println); //Volgorde van input is behouden in de set
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
