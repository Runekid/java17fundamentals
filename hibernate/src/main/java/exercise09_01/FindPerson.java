package exercise09_01;

import java.util.*;

import javax.persistence.*;
import javax.persistence.criteria.*;

public class FindPerson {
   public static void main(String[] args) {
      EntityManagerFactory emf = null;
      EntityManager em = null;
      try {
         emf = Persistence.createEntityManagerFactory("course");
         em = emf.createEntityManager();
         EntityTransaction tx = em.getTransaction();
         tx.begin();

         CriteriaBuilder cb = em.getCriteriaBuilder();

         CriteriaQuery<Person> cq = cb.createQuery(Person.class);

         // Selection: from Person as p
         Root<Person> p = cq.from(Person.class);

         // Projection: select p
         cq.select(p);

         // Restriction: where p.firstName = 'Homer' and p.lastName =
         // 'Simpson'
         // cq.where(cb.and(cb.equal(p.get("firstName"),"Homer"),
         // cb.equal(p.get("lastName"),"Simpson")));

         List<Predicate> predicates = new ArrayList<>();
         predicates.add(cb.equal(p.get("firstName"), "Homer"));
         predicates.add(cb.equal(p.get("lastName"), "Simpson"));
         cq.where(predicates.toArray(new Predicate[0]));

         TypedQuery<Person> query = em.createQuery(cq);
         query.getResultStream().forEach(System.out::println);
         tx.commit();
      } finally {
         if (em != null)
            em.close();
         if (emf != null)
            emf.close();
      }
   }
}
