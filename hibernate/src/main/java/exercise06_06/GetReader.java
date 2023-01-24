package exercise06_06;

import exercise06_04.Patient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetReader {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Reader reader = null;
        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            //Patient patient = em.find(Patient.class, 1L);
            reader = em.getReference(Reader.class, 1L);
            // when the the fetch type is lazy,
            // the medicalfile needs to be called before the persistence context is closed
            // if you want to access it outside of it
            System.out.println(reader);
            tx.commit();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
        System.out.println(reader);
    }
}
