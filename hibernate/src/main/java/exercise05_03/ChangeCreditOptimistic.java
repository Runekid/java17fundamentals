package exercise05_03;

import javax.persistence.*;
import javax.swing.JOptionPane;

public class ChangeCreditOptimistic {
   public static void main(String[] args) {
      EntityManagerFactory emf = null;
      EntityManager em = null;
      try {
         emf = Persistence.createEntityManagerFactory("course");
         em = emf.createEntityManager();
         Cache cache = emf.getCache();
         EntityTransaction tx = em.getTransaction();
         tx.begin();
         Credit credit = em.find(Credit.class, 1L);
         tx.commit();
         em.close();

         String answer = JOptionPane.showInputDialog(
               "Current balance: " + credit.getBalance()
                     + ". Change with: ");

         if (answer != null) {
            float amount = Float.valueOf(answer);
            if ((credit.getBalance() + amount) >= 0F) {
               credit.setBalance(credit.getBalance() + amount);

               em = emf.createEntityManager();
               tx = em.getTransaction();
               tx.begin();
               em.merge(credit);
               tx.commit();
               em.close();
               System.out.println("Credit changed");
            } else {
               System.out.println("Unsufficient credit");
            }
         }
      } catch (OptimisticLockException ex) {
         JOptionPane.showMessageDialog(null, ex.getMessage(),
               "Error", JOptionPane.ERROR_MESSAGE);
      } finally {
         if (emf != null)
            emf.close();
      }
   }
}
