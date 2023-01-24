package exercise06_06;

import exercise06_04.MedicalFile;
import exercise06_04.Patient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveReader {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Reader reader = new Reader();
            Magazine magazine = new Magazine();
            magazine.setName("Times");
            Magazine magazine1 = new Magazine();
            magazine1.setName("knack");
            reader.getMagazines().add(magazine);
            reader.getMagazines().add(magazine1);
            em.persist(reader);
            tx.commit();
            System.out.println("reader and magazines saved");

        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}
