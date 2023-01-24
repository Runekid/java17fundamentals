package exercise06_04;

import exercise06_01.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class SavePatient {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Patient patient = new Patient();
            patient.setName("Onur");
            MedicalFile medicalFile = new MedicalFile();
            medicalFile.setHeight(166F);
            medicalFile.setWeight(74F);
            patient.setMedicalFile(medicalFile);
            em.persist(patient);
            em.persist(medicalFile);
            tx.commit();
            System.out.println("patient and medical file saved");

        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}
