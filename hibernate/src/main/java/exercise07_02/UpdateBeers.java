package exercise07_02;

import javax.persistence.*;

public class UpdateBeers {
   public static void main(String[] args) {
      EntityManagerFactory emf = null;
      EntityManager em = null;
      try {
         emf = Persistence.createEntityManagerFactory("course");
         em = emf.createEntityManager();
         EntityTransaction tx = em.getTransaction();
         tx.begin();
         // Query query = em.createQuery("update Beer b set b.price =
         // b.price*1.02");
         Query query = em.createNamedQuery("update");
         int result = query.executeUpdate();
         tx.commit();
         System.out.println(result + " bieren aangepast");
      } finally {
         if (em != null)
            em.close();
         if (emf != null)
            emf.close();
      }
   }
}
