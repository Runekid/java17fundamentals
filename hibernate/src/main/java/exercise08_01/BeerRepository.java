package exercise08_01;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.*;

public class BeerRepository {
   private EntityManagerFactory emf;

   public void init() {
      emf = Persistence
              .createEntityManagerFactory("course");
   }

   public void close() {
      if(emf != null) {
         emf.close();
      }
   }

   public List<Beer> getBeersByCriteria(String name,
         Float alcohol, String brewer, String category) {
      EntityManager em = null;
      try {
         em = emf.createEntityManager();
         EntityTransaction tx = em.getTransaction();
         tx.begin();
         CriteriaBuilder cb = em.getCriteriaBuilder();
         CriteriaQuery<Beer> cq = cb.createQuery(Beer.class);
         Root<Beer> b = cq.from(Beer.class);
         cq.select(b);

         List<Predicate> criteria = new ArrayList<Predicate>();
         if (name != null) {
            criteria.add(cb.equal(b.get("name"), name));
         }
         if (alcohol != null) {
            criteria.add(cb.equal(b.get("alcohol"), alcohol));
         }
         if (brewer != null) {
            criteria.add(
                  cb.equal(b.get("brewer").get("name"), brewer));
         }
         if (category != null) {
            criteria.add(cb.equal(b.get("category").get("name"),
                  category));
         }

         cq.where(criteria.toArray(new Predicate[0]));
         TypedQuery<Beer> q = em.createQuery(cq);
         List<Beer> result = q.getResultList();
         tx.commit();
         return result;
      } finally {
         if (em != null)
            em.close();
      }
   }
}
