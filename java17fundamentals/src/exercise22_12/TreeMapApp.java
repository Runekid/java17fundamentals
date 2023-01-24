package exercise22_12;

import exercise22_10.Person;

import java.util.*;

public class TreeMapApp {
    public static void main(String[] args) {
        NavigableMap<String,Person> persons = new TreeMap();
        persons.put("Aap", new Person("Aap", "Bugdayci", exercise22_10.Person.GENDER.MAN, 25, 75F, 1.67F));
        persons.put("Citroen", new Person("Citroen", "test", exercise22_10.Person.GENDER.WOMAN, 29, 72F, 1.68F));
        persons.put("Druif", new Person("Druif", "test", exercise22_10.Person.GENDER.WOMAN, 23, 70F, 1.68F));
        persons.put("Banaan", new Person("Banaan", "Bugdayci", Person.GENDER.MAN, 25, 79F, 1.66F));

        persons.forEach((k,v) -> System.out.printf("%s %s %n",k,v)); //volgorde is alfabetisch want treemap is gesorteerd op sleutel
        System.out.println(persons.get("Druif"));
        System.out.println(persons.lastEntry().getValue());
        System.out.println(persons.firstEntry().getValue());
    }
}
