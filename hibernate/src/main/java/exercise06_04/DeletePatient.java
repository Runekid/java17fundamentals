package exercise06_04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeletePatient {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Patient patient = null;
        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            patient = em.getReference(Patient.class, 1L);
            em.remove(patient);
            System.out.println(patient);
            tx.commit();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
        //System.out.println(patient);
    }
}
