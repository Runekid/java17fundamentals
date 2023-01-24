package exercise07_02;

import java.util.List;

import javax.persistence.*;

public class Find {
   private static EntityManager em;

   public static void main(String[] args) {
      EntityManagerFactory emf = null;
      try {
         emf = Persistence.createEntityManagerFactory("course");
         em = emf.createEntityManager();
         doQuery("Beers with alcohol 8", "beers[8]");
         doQuery("Beers between 5 and 8", "beers[5-8]");
         doQuery("Beers of 4,6,8 and 10", "beers[4,6,8,10]");
         doQuery("Beers with the name 'kriek'", "beers[kriek]");
         doQuery("Beers from Gent", "beers[gent]");
         doQuery("Tripels", "beers[tripel]");
         doQuery("Categories of 9 degrees", "category[9]");
         doQuery("Categories of 9 degrees (bis)",
               "category[9]bis");
         doQuery("Brewers with beers of 10", "brewer[10]");
         doQuery("Brewers with beers of 10 (bis)",
               "brewer[10]bis");
         doQuery("Brewers brewing pils", "brewer[pils]");
         doQuery("Brewers brewing pils (bis)",
               "brewer[pils]bis");
         doQuery("Number of beers per alcohol",
               "report[alcohol]");
         doQuery("Beers per city", "report[city]");
         doQuery("Strongest beers", "beers[strongest]");
         doQuery("Average price of pils beers",
               "averagePrice[pils]");

      } finally {
         if (em != null)
            em.close();
         if (emf != null)
            emf.close();
      }
   }

   private static void doQuery(String title, String queryName) {
      System.out.println("\n***" + title + "***");
      Query q = em.createNamedQuery(queryName);
      List<?> list = q.getResultList();
      for (Object o : list) {
         if (o instanceof Object[]) {
            Object[] or = (Object[]) o;
            for (Object ob : or) {
               System.out.print(ob + " ");
            }
            System.out.println();
         } else {
            System.out.println(o);
         }
      }
   }
}
