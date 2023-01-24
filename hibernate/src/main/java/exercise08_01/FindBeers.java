package exercise08_01;

import javax.persistence.*;
import java.util.*;

public class FindBeers {
   public static void main(String[] args) {
      EntityManagerFactory emf = null;
      EntityManager em = null;
      List<Beer> beers = null;
      try {
         emf = Persistence.createEntityManagerFactory("course");
         em = emf.createEntityManager();

         EntityGraph eg =
               em.createEntityGraph("beers-entity-graph");
         TypedQuery<Beer> query =
               em.createNamedQuery("findAllBeers", Beer.class);
         query.setFirstResult(0);
         query.setMaxResults(20);
         query.setHint("javax.persistence.fetchgraph", eg);
         beers = query.getResultList();
      } finally {
         if (em != null)
            em.close();
         if (emf != null)
            emf.close();
      }
      for (Beer b : beers) {
         System.out.format("%s %s %n", b.getBrewer().getName(),
               b.getCategory().getName());
      }
   }
}
