package com.vaadin.training.push.exercises.backend;

import com.vaadin.training.push.exercises.data.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonService {

	private static String[] firstName = { "James", "John", "Robert", "Michael", "William", "David", "Richard",
			"Charles", "Joseph", "Christopher", "Mary", "Patricia", "Linda", "Barbara", "Elizabeth", "Jennifer",
			"Maria", "Susan", "Margaret", "Dorothy", "Lisa" };

	private static String[] lastName = { "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson",
			"Moore", "Taylor", "Andreson", "Thomas", "Jackson", "White" };

	private final Set<Person> persons = new HashSet<>();

	public List<Person> getEmployees() {

		for (int i = 0; i < 500; i++) {
			persons.add(generatePerson(i));
		}

		return new ArrayList<>(persons);
	}

	private Person generatePerson(int i) {
		final Person person = new Person();

		person.setId(i);
		final int firstNameIndex = (int) Math.round(Math.random() * 10000) % firstName.length;
		person.setFirstName(firstName[firstNameIndex]);
		final int lastNameIndex = (int) Math.round(Math.random() * 10000) % lastName.length;
		person.setLastName(lastName[lastNameIndex]);

		person.setEmail(
				person.getFirstName().toLowerCase() + "." + person.getLastName().toLowerCase() + "@example.com");

		try {
			Thread.sleep(5);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		return person;
	}
}
