package exercise07_03;

import exercise06_09.MultiMedia;

import javax.persistence.*;

public class FindMultiMedia {
   public static void main(String[] args) throws Exception {
      EntityManagerFactory emf = null;
      EntityManager em = null;
      try {
         emf = Persistence.createEntityManagerFactory("course");
         em = emf.createEntityManager();
         EntityTransaction tx = em.getTransaction();
         tx.begin();

         TypedQuery<MultiMedia> query = em.createQuery(
               "select m from MultiMedia as m where m.author='onur'",
               MultiMedia.class);
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
