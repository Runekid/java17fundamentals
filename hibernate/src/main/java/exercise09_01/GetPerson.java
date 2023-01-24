package exercise09_01;

import java.text.*;
import javax.persistence.*;

public class GetPerson {
   public static void main(String[] args) {
      EntityManagerFactory emf = null;
      EntityManager em = null;
      try {
         emf = Persistence.createEntityManagerFactory("course");
         em = emf.createEntityManager();
         EntityTransaction tx = em.getTransaction();
         tx.begin();
         Person person = em.find(Person.class, 1L);
         tx.commit();
         em.close();
         System.out.println(person.getFirstName());
         System.out.println(person.getLastName());
         System.out.println(person.getBirthDay());
         System.out.println(person.getAge());
         System.out.println(person.getGender());
         System.out.println(person.getComment());

      } finally {
         if (em != null)
            em.close();
         if (emf != null)
            emf.close();
      }
   }
}
