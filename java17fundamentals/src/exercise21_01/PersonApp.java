package exercise21_01;

import java.util.stream.Stream;

public class PersonApp {
    public static void main(String[] args) {
        Person[] persons = new Person[2];
        persons[0] = new Person("Onur", "Bugdayci", Person.GENDER.MAN, 25, 75F, 1.66F);
        persons[1] = new Person("Runo", "test", Person.GENDER.WOMAN, 23, 72F, 1.68F);

        Stream.of(persons).forEach(System.out::println);
    }
}
