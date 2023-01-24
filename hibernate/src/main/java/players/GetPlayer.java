package players;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetPlayer {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Player player = em.find(Player.class, new PlayerPK("AA Gent", 7));
            tx.commit();
            System.out.println(player);
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
