package exercise07_04;

import java.util.*;

import javax.persistence.*;
import javax.persistence.criteria.*;

public class BeerRepository {
   /*private EntityManagerFactory emf;

   public void init() {
      emf = Persistence.createEntityManagerFactory("course");
   }

   public void close() {
      if (emf != null) {
         emf.close();
      }
   }

   public List<Beer> getBeersByCriteria(String name, Float alcohol,
                                        String brewer,
                                        String category) {
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
            criteria.add(cb.equal(b.get(Beer_.name), name));
         }
         if (alcohol != null) {
            criteria.add(cb.equal(b.get(Beer_.alcohol), alcohol));
         }
         if (brewer != null) {
            criteria.add(cb
                  .equal(b.get(Beer_.brewer).get(Brewer_.name),
                        brewer));
         }
         if (category != null) {
            criteria.add(cb
                  .equal(b.get(Beer_.category).get(Category_.name),
                        category));
         }

         cq.where(criteria.toArray(new Predicate[criteria.size()]));
         TypedQuery<Beer> q = em.createQuery(cq);
         List<Beer> result = q.getResultList();
         tx.commit();
         return result;
      } finally {
         if (em != null)
            em.close();
      }
   }*/
}
