package exercise06_07;

import exercise06_06.Member;
import exercise06_06.Organisation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class SaveGraduate {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Graduate graduate = new Graduate();
            graduate.setName("Onur");
            DegreeRelation degreeRelation = new DegreeRelation();
            degreeRelation.setDate(new Date());
            degreeRelation.setLevel(1);
            DegreeRelation degreeRelation1 = new DegreeRelation();
            degreeRelation.setDate(Date.from(LocalDate.of(1212,4,4).atStartOfDay(ZoneId.systemDefault()).toInstant()));
            degreeRelation.setLevel(2);
            Degree degree = new Degree();
            degree.setName("economie");
            Degree degree1 = new Degree();
            degree1.setName("ict");
            degreeRelation.setDegree(degree);
            degreeRelation1.setDegree(degree1);
            graduate.getDegreeRelations().add(degreeRelation);
            graduate.getDegreeRelations().add(degreeRelation1);
            em.persist(graduate);
            em.persist(degree);
            em.persist(degree1);
            em.persist(degreeRelation);
            em.persist(degreeRelation1);

            tx.commit();
            System.out.println("graduate saved");

        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}
