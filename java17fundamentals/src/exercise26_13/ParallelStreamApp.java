package exercise26_13;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.LongStream;

public class ParallelStreamApp {
    public static void main(String[] args) {
        OptionalDouble sum = LongStream.rangeClosed(1,1_000_000_000L)
                .parallel() //with parallellism it takes around 3 times as less time to process
                .mapToDouble(Math::sqrt)
                .map(Math::log)
                .average();
    }
}
