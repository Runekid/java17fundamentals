package exercise23_06;

import java.io.*;
import java.time.LocalDate;

public class Maternity {
    public static void main(String[] args) {
        Person person = new Person("Onur","Bugdayci", LocalDate.of(1996,4,4));
        try (FileOutputStream fileOutputStream = new FileOutputStream(person.getFirstName()+".ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
