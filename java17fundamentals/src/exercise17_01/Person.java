package exercise17_01;

import java.util.Objects;
import java.util.StringJoiner;

public record Person(String firstName, String lastName, int age) {
    public Person{
        Objects.requireNonNull(firstName, "firstName cannot be null");
        Objects.requireNonNull(lastName, "lastName cannot be null");
        if(age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    public Person(String firstName, String lastName) {
        this(firstName,lastName,0);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("age=" + age)
                .toString();
    }
}
