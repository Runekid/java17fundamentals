package exercise06_04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteMedicalFile {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Patient patient = null;
        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            patient = em.find(Patient.class, 1L);
            patient.removeMedicalFile();
            System.out.println(patient);
            tx.commit();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
