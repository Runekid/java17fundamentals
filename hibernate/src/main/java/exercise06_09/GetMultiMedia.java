package exercise06_09;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class GetMultiMedia {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            MultiMedia multiMedia = em.getReference(MultiMedia.class, 1L);



            Book book = em.getReference(Book.class, 2L);



            EBook eBook = em.getReference(EBook.class, 3L);


            AudioVisual audioVisual = em.getReference(AudioVisual.class, 4L);


            CD cd = em.getReference(CD.class, 5L);


            DVD dvd = em.getReference(DVD.class, 6L);

            System.out.println(multiMedia);
            System.out.println(book);
            System.out.println(eBook);
            System.out.println(audioVisual);
            System.out.println(cd);
            System.out.println(dvd);

            tx.commit();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
