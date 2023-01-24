package workspace;

import java.util.stream.Stream;

public class StreamsTest {
    public static void main(String[] args) {
        Stream<String> stream = Stream.generate(() -> "Hello world");
        stream.forEach(System.out::println);
    }
}
