package exercise06_05;

import exercise06_04.MedicalFile;
import exercise06_04.Patient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveSchool {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            School school = new School();
            school.setName("Piusx");
            Student student1 = new Student();
            student1.setName("onur");
            Student student2 = new Student();
            student2.setName("runo");
            school.getStudents().add(student1);
            student1.setSchool(school);
            school.getStudents().add(student2);
            student2.setSchool(school);

            em.persist(school);
            em.persist(student1);
            em.persist(student2);


            tx.commit();
            System.out.println("school and students saved");

        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}
