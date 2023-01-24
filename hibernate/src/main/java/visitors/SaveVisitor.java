package visitors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveVisitor {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Visitor visitor = new Visitor("Onur", 25);
            em.persist(visitor);
            tx.commit();
            System.out.println("Visitor saved");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
