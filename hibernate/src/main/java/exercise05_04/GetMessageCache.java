package exercise05_04;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetMessageCache {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Message message = new Message(2, "Goodbye World");
            tx.commit();
            System.out.println("Message saved");
            System.out.println(emf.getCache().contains(Message.class, 2L));
            emf.getCache().evictAll();
            System.out.println(emf.getCache().contains(Message.class, 2L));
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
