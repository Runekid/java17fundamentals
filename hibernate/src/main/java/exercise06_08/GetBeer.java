package exercise06_08;

import javax.persistence.*;

public class GetBeer {
   public static void main(String[] args) {
      EntityManagerFactory emf = null;
      EntityManager em = null;
      try {
         emf = Persistence.createEntityManagerFactory("course");
         em = emf.createEntityManager();
         EntityTransaction tx = em.getTransaction();
         tx.begin();
         Beer beer = em.find(Beer.class, 229);
         System.out.println(beer.getName());
         System.out.println(beer.getBrewer().getName());
         System.out.println(beer.getCategory().getName());
         tx.commit();
      } finally {
         if (em != null)
            em.close();
         if (emf != null)
            emf.close();
      }
   }
}
