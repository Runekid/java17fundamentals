package exercise23_08;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class Maternity {
    public static void main(String[] args) {
        Person person = new Person("Onur","Bugdayci", LocalDate.of(1996,4,4));
        try (FileOutputStream fileOutputStream = new FileOutputStream(person.getFirstName()+".ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(person);
            System.in.read(); // zodat we de hearbeat kunnen zien
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
