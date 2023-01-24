package exercise23_08;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CivilService {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("Onur.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Person p = (Person) objectInputStream.readObject();
            System.out.println(p.toString());
            System.in.read(); // zodat we de hearbeat kunnen zien
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
