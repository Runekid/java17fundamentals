package exercise10_01;

import java.time.LocalDate;

import javax.persistence.*;

public class SaveCar {
   public static void main(String[] args) {
      EntityManagerFactory emf = null;
      EntityManager em = null;
      try {
         emf = Persistence.createEntityManagerFactory("course");
         em = emf.createEntityManager();
         EntityTransaction tx = em.getTransaction();
         tx.begin();
         Car car = new Car();
         car.setBrand("Ford");
         car.setType("Fiesta");
         car.setPlate("1-AMD-116");
         car.setEntryIntoService(LocalDate.of(2016, 1, 1));
         car.setListPrice(23000.00F);
         car.setPower(100);
         em.persist(car);
         tx.commit();
         System.out.println("Saved");
      } finally {
         if (em != null)
            em.close();
         if (emf != null)
            emf.close();
      }
   }
}
