package exercise06_02;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class SavePerson {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            // Read picture
            Path pathHomer = Paths.get("homer.jpg");
            byte[] pictureHomer = Files.readAllBytes(pathHomer);

            Address address = new Address();
            address.setStreet("Breughelpark");
            address.setNumber("18");
            address.setZipcode("1731");
            address.setCity("Zellik");
            address.setCountry("Belgium");
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Person person = new Person("Onur", "Bugdayci", LocalDate.of(1996, 04, 04), Person.GENDER.APACHE_HEL, pictureHomer, "this is a comment", false, "www.google.be");
            person.setAddress(address);
            em.persist(person);
            tx.commit();
            System.out.println("person saved");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}
