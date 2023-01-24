package exercise22_10;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonApp {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Aap", "Bugdayci", Person.GENDER.MAN, 25, 75F, 1.67F));
        persons.add(new Person("Citroen", "test", Person.GENDER.WOMAN, 29, 72F, 1.68F));
        persons.add(new Person("Druif", "test", Person.GENDER.WOMAN, 23, 70F, 1.68F));
        persons.add(new Person("Banaan", "Bugdayci", Person.GENDER.MAN, 25, 79F, 1.66F));

        List<Person> list2 = persons.stream()
                .filter(person -> person.getGender() == Person.GENDER.WOMAN)
                .filter(person -> person.getAge() > 20)
                .sorted(Comparator.comparingInt(Person::getAge))
                .toList();

        list2.forEach(System.out::println);
    }
}
