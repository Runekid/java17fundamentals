package exercise06_01;


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
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Person person = new Person("Onur", "Bugdayci", LocalDate.of(1996, 04, 04), Person.GENDER.APACHE_HEL, pictureHomer, "this is a comment", false, "www.google.be");
            em.persist(person);
            tx.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}
