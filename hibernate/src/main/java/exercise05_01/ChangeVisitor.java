package exercise05_01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ChangeVisitor {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        //Visitor visitor;
        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Visitor visitor = em.find(Visitor.class, 1L);
            //visitor = em.find(Visitor.class, 1L);
            //em.clear(); // no change
            em.detach(visitor); // no change
            visitor.setName("ChangedClear");
            tx.commit();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();

        }
        //visitor.setName("ChangedAgain"); // outside of persistence context -> no change
    }
}
