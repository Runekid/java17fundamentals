package exercise07_02;

import javax.persistence.*;

public class FindBeers {
   public static void main(String[] args) {
      EntityManagerFactory emf = null;
      EntityManager em = null;
      try {
         emf = Persistence.createEntityManagerFactory("course");
         em = emf.createEntityManager();
         EntityTransaction tx = em.getTransaction();
         tx.begin();
         TypedQuery<Object[]> query = em.createQuery(
               "select b.name, b.alcohol from Beer as b",
               Object[].class);
         query.setMaxResults(10);
         query.getResultStream()
               .forEach(e -> System.out.format("%s %s%n", e[0],
                     e[1]));

         TypedQuery<Long> query2 = em.createQuery(
               "select count(b) from Beer as b", Long.class);
         Long result = query2.getSingleResult();
         System.out.println(result);

         tx.commit();
      } finally {
         if (em != null)
            em.close();
         if (emf != null)
            emf.close();
      }
   }
}
