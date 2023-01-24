package exercise21_01;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsApp {
    public static void main(String[] args) {
        String[] strings = {"Hello","world"};
        Stream.of(strings).forEach(System.out::println);

        IntStream.range(0, 100).forEach(System.out::println);
    }
}
