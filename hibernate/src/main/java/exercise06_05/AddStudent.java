package exercise06_05;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddStudent {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        School school = null;
        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            //Patient patient = em.find(Patient.class, 1L);
            school = em.getReference(School.class, 1L);
            Student student = new Student();
            student.setName("mark");
            student.setSchool(school);
            school.getStudents().add(student);
            //em.persist(student); //only need to persist school because the cascade type is persist on the relation
            em.persist(school);
            System.out.println(school);
            tx.commit();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
        System.out.println(school);
    }
}
