package exercise22_07;


import java.util.*;

public class PersonApp {
    public static void main(String[] args) {
        /*SortedSet<Person> persons = new TreeSet<>(new AgeComparator());
        persons.add(new Person("Aap", "Bugdayci", Person.GENDER.MAN, 25, 75F, 1.67F));
        persons.add(new Person("Citroen", "test", Person.GENDER.WOMAN, 23, 72F, 1.68F));
        persons.add(new Person("Druif", "test", Person.GENDER.WOMAN, 23, 70F, 1.68F));
        persons.add(new Person("Banaan", "Bugdayci", Person.GENDER.MAN, 25, 79F, 1.66F));*/

        /*SortedSet<Person> persons = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return (int) (o1.getWeight() - o2.getWeight());
            }
        });
        persons.add(new Person("Aap", "Bugdayci", Person.GENDER.MAN, 25, 75F, 1.67F));
        persons.add(new Person("Citroen", "test", Person.GENDER.WOMAN, 23, 72F, 1.68F));
        persons.add(new Person("Druif", "test", Person.GENDER.WOMAN, 23, 70F, 1.68F));
        persons.add(new Person("Banaan", "Bugdayci", Person.GENDER.MAN, 25, 79F, 1.66F));*/

        /*SortedSet<Person> persons = new TreeSet<>(Comparator.comparingDouble(person -> person.getWeight()));
        persons.add(new Person("Aap", "Bugdayci", Person.GENDER.MAN, 25, 75F, 1.67F));
        persons.add(new Person("Citroen", "test", Person.GENDER.WOMAN, 23, 72F, 1.68F));
        persons.add(new Person("Druif", "test", Person.GENDER.WOMAN, 23, 70F, 1.68F));
        persons.add(new Person("Banaan", "Bugdayci", Person.GENDER.MAN, 25, 79F, 1.66F));*/

        /*SortedSet<Person> persons = new TreeSet<>(Comparator
                .comparingInt((Person person) -> person.getAge())
                .thenComparingDouble((Person person) -> person.getWeight())
                .thenComparing((Person person1, Person person2) -> person1.getFirstName().compareTo(person2.getFirstName())));
        persons.add(new Person("Aap", "Bugdayci", Person.GENDER.MAN, 25, 75F, 1.67F));
        persons.add(new Person("Citroen", "test", Person.GENDER.WOMAN, 23, 72F, 1.68F));
        persons.add(new Person("Druif", "test", Person.GENDER.WOMAN, 23, 70F, 1.68F));
        persons.add(new Person("Banaan", "Bugdayci", Person.GENDER.MAN, 25, 79F, 1.66F));*/
        SortedSet<Person> persons = new TreeSet<>(Comparator
                .comparingInt(Person::getAge)
                .thenComparingDouble(Person::getWeight)
                .thenComparing(Person::getFirstName));
        persons.add(new Person("Aap", "Bugdayci", Person.GENDER.MAN, 25, 75F, 1.67F));
        persons.add(new Person("Citroen", "test", Person.GENDER.WOMAN, 23, 72F, 1.68F));
        persons.add(new Person("Druif", "test", Person.GENDER.WOMAN, 23, 70F, 1.68F));
        persons.add(new Person("Banaan", "Bugdayci", Person.GENDER.MAN, 25, 79F, 1.66F));

        persons.forEach(System.out::println);
    }
}
