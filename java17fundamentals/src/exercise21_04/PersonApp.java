package exercise21_04;

import java.util.stream.Stream;

public class PersonApp {
    public static void main(String[] args) {
        Person[] persons = new Person[4];
        persons[0] = new Person("Onur", "Bugdayci", Person.GENDER.MAN, 25, 75F, 1.66F);
        persons[1] = new Person("Runo", "test", Person.GENDER.WOMAN, 23, 72F, 1.68F);
        persons[2] = new Person("Bruno", "test", Person.GENDER.WOMAN, 23, 70F, 1.68F);
        persons[3] = new Person("Onur", "Bugdayci", Person.GENDER.MAN, 25, 80F, 1.66F);

        //Stream.of(persons).filter(person -> person.getGender().equals(Person.GENDER.WOMAN)).forEach(System.out::println);
        /*Stream.of(persons)
                .filter(person -> person.getAge() > 24)
                .forEach(System.out::println);*/

        /*Stream.of(persons)
                .filter(person -> person.getWeight() > 70F)
                .filter(person -> person.getWeight() < 75F)
                .forEach(System.out::println);*/

        /*Stream.of(persons)
                .filter(person -> person.getAge() > 23 && person.getWeight() > 75F)
                .forEach(System.out::println);*/

        /*Stream.of(persons)
                .mapToInt(person -> person.getAge())
                .forEach(System.out::println);*/
        /*Stream.of(persons)
                .mapToInt(Person::getAge)
                .forEach(System.out::println); vorige oefening maar korter (van solution gehaald)*/
        /*Stream.of(persons)
                .map(person -> person.getFirstName() + " " + person.getLastName())
                .forEach(System.out::println);*/

        /*System.out.println(Stream.of(persons)
                .mapToDouble(Person::getAge)
                .average()
                .getAsDouble());
        System.out.println(Stream.of(persons).mapToInt(Person::getAge).min().getAsInt());
        System.out.println(Stream.of(persons).mapToInt(Person::getAge).max().getAsInt());

        Stream.of(persons).mapToDouble(Person::getWeight).forEach(System.out::println);*/

        /*System.out.println(Stream.of(persons).mapToDouble(Person::getWeight).average().getAsDouble());
        System.out.println(Stream.of(persons).mapToDouble(Person::getWeight).min().getAsDouble());
        System.out.println(Stream.of(persons).mapToDouble(Person::getWeight).max().getAsDouble());*/


    }
}
