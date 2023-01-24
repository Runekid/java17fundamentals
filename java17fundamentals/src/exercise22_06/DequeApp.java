package exercise22_06;

import exercise22_02.Person;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DequeApp {
    public static void main(String[] args) {
        Deque<Person> persons = new LinkedList<>();
        persons.offerLast(new exercise22_02.Person("Onur", "Bugdayci", exercise22_02.Person.GENDER.MAN, 25, 75F, 1.66F));
        persons.offerFirst(new exercise22_02.Person("woman1", "test", exercise22_02.Person.GENDER.WOMAN, 23, 72F, 1.68F));
        persons.offerFirst(new exercise22_02.Person("woman2", "test", exercise22_02.Person.GENDER.WOMAN, 23, 70F, 1.68F));
        persons.offerLast(new exercise22_02.Person("Onur2", "Bugdayci", Person.GENDER.MAN, 25, 75F, 1.66F));

        Person currentMan = persons.peekLast();
        Person currentWoman = persons.peekFirst();
        while (currentMan != null && currentWoman != null) {
            System.out.println("About to couple " + currentWoman.getFirstName() + " and " + currentMan.getFirstName());
            System.out.println("Coupling " + persons.pollFirst().getFirstName() + " and " + persons.pollLast().getFirstName());
            currentMan = persons.peekLast();
            currentWoman = persons.peekFirst();
        }
    }
}
