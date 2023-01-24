package exercise22_08;


import java.util.*;

public class PersonApp {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Aap", "Bugdayci", Person.GENDER.MAN, 25, 75F, 1.67F));
        persons.add(new Person("Citroen", "test", Person.GENDER.WOMAN, 23, 72F, 1.68F));
        persons.add(new Person("Druif", "test", Person.GENDER.WOMAN, 23, 70F, 1.68F));
        persons.add(new Person("Banaan", "Bugdayci", Person.GENDER.MAN, 25, 79F, 1.66F));

        persons.sort(Comparator.naturalOrder());
        //persons.forEach(System.out::println);
        persons.sort(Comparator.comparingDouble(Person::getWeight));
        persons.forEach(System.out::println);
    }
}
