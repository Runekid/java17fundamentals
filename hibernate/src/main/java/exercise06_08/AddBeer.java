package exercise06_08;

import javax.persistence.*;

public class AddBeer {
   public static void main(String[] args) {
      EntityManagerFactory emf = null;
      EntityManager em = null;
      try {
         emf = Persistence.createEntityManagerFactory("course");
         em = emf.createEntityManager();
         EntityTransaction tx = em.getTransaction();
         tx.begin();
         Brewer brewer = em.getReference(Brewer.class, 124);
         Category category = em.getReference(Category.class, 59);

         Beer beer = new Beer();
         beer.setAlcohol(13);
         beer.setBrewer(brewer);
         brewer.getBeers().add(beer);
         beer.setCategory(category);
         category.getBeers().add(beer);
         beer.setName("Westvleteren christmas beer");
         beer.setPrice(5);
         beer.setStock(100);
         em.persist(beer);
         tx.commit();
         System.out.println(beer);
         System.out.println(beer.getBrewer());
         System.out.println(beer.getCategory());
      } finally {
         if (em != null)
            em.close();
         if (emf != null)
            emf.close();
      }
   }
}
