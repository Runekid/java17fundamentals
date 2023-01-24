package exercise21_04;

import java.util.Arrays;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class BigExtraDifficultLastTwoQuestionsApp {
    public static void main(String[] args) {
        /*System.out.println(IntStream.rangeClosed(0, 10000).filter(num -> num % 5 == 0 && num % 8 == 0)
                .mapToDouble(Math::sqrt)
                .sum());*/

        int[] randoms = new Random().ints(0,10000)
                .filter(num -> num % 2 == 0)
                .distinct()
                .limit(500)
                .sorted()
                .toArray();
        for (int random : randoms) {
            System.out.println(random);
        }

        System.out.println(randoms.length);

    }
}
