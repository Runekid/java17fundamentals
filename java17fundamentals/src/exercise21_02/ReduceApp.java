package exercise21_02;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceApp {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4};

        System.out.println(IntStream.of(numbers).reduce(0, (acc, el) -> acc += el * el));

        String[] words = {"this", "is", "not", "joined"};
        System.out.println(Stream.of(words).reduce("", (acc, el) -> acc += el + ","));
    }
}
