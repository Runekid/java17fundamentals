package exercise09_01;

import java.nio.file.*;
import java.time.LocalDate;

import javax.persistence.*;

public class SavePerson {
   public static void main(String[] args) throws Exception {
      EntityManagerFactory emf = null;
      EntityManager em = null;
      try {
         emf = Persistence.createEntityManagerFactory("course");
         em = emf.createEntityManager();

         // Read picture
         Path pathHomer = Paths.get("homer.jpg");
         byte[] pictureHomer = Files.readAllBytes(pathHomer);

         Path pathMarge = Paths.get("marge.jpg");
         byte[] pictureMarge = Files.readAllBytes(pathMarge);

         EntityTransaction tx = em.getTransaction();
         tx.begin();
         Person homer = new Person();
         homer.setFirstName("Homer");
         homer.setLastName("Simpson");
         homer.setBirthDay(LocalDate.of(2012,6,8));
         homer.setGender(GenderType.MALE);
         homer.setPicture(pictureHomer);
         homer.setComment("Some comment about Homer ");
         homer.setMarried(true);
         homer.setHomepage("www.thesimpsons.com");
         homer.getAddress().setStreet("Evergreen Terrace");
         homer.getAddress().setNumber("742");
         homer.getAddress().setZipCode("01101");
         homer.getAddress().setCity("Springfield");
         homer.getAddress().setCountry("USA");

         em.persist(homer);
         em.flush();
         System.out.println(homer.getId());
         Person marge = new Person();
         marge.setFirstName("Marge");
         marge.setLastName("Simpson");
         marge.setBirthDay(LocalDate.of(2014, 5, 13));
         marge.setGender(GenderType.FEMALE);
         marge.setPicture(pictureMarge);
         marge.setComment("Some comment about Marge ");
         marge.setMarried(true);
         marge.setHomepage("www.thesimpsons.com");
         marge.getAddress().setStreet("Evergreen Terrace");
         marge.getAddress().setNumber("742");
         marge.getAddress().setZipCode("01101");
         marge.getAddress().setCity("Springfield");
         marge.getAddress().setCountry("USA");
         marge.setHomepage("www.thesimpsons.com");

         em.persist(marge);
         em.flush();
         System.out.println(marge.getId());
         tx.commit();
         System.out.println("Persons saved");
      } finally {
         if (em != null)
            em.close();
         if (emf != null)
            emf.close();
      }
   }
}
