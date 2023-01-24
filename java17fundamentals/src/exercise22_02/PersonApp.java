package exercise22_02;

import java.util.HashSet;
import java.util.Set;

public class PersonApp {
    public static void main(String[] args) {
        Set<Person> persons = new HashSet<>();
        persons.add(new Person("Onur", "Bugdayci", Person.GENDER.MAN, 25, 75F, 1.66F));
        persons.add(new Person("Runo", "test", Person.GENDER.WOMAN, 23, 72F, 1.68F));
        persons.add(new Person("Bruno", "test", Person.GENDER.WOMAN, 23, 70F, 1.68F));
        persons.add(new Person("Onur", "Bugdayci", Person.GENDER.MAN, 25, 75F, 1.66F));

        for (Person person : persons) {
            System.out.println(person); // de volgorde is willekeurig en duplicaat is ook toegevoegd omdat ik de hashCode en equals methodes niet veranderd heb
        }
        //Ik heb een equals en hashCode methodes gegenereert op Person en nu is de duplicaat niet in de set, volgorde is nog willekeurig



    }
}
