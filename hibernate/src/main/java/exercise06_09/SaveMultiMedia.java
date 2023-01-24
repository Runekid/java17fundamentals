package exercise06_09;

import messages.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class SaveMultiMedia {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            MultiMedia multiMedia = new MultiMedia();
            multiMedia.setTitle("the wire");
            multiMedia.setAuthor("Dave Simmons");
            multiMedia.setPublisher("HBO");
            multiMedia.setPubDate(LocalDate.now());
            em.persist(multiMedia);

            Book book = new Book();
            book.setTitle("the wire");
            book.setAuthor("Dave Simmons");
            book.setPublisher("HBO");
            book.setPubDate(LocalDate.now());
            book.setPages(12);
            em.persist(book);

            EBook eBook = new EBook();
            eBook.setTitle("the wire");
            eBook.setAuthor("Dave Simmons");
            eBook.setPublisher("HBO");
            eBook.setPubDate(LocalDate.now());
            eBook.setPages(12);
            eBook.setUrl("google.com");
            em.persist(eBook);

            AudioVisual audioVisual = new AudioVisual();
            audioVisual.setTitle("the wire");
            audioVisual.setAuthor("Dave Simmons");
            audioVisual.setPublisher("HBO");
            audioVisual.setPubDate(LocalDate.now());
            audioVisual.setDuration(10);
            em.persist(audioVisual);

            CD cd = new CD();
            cd.setTitle("the wire");
            cd.setAuthor("Dave Simmons");
            cd.setPublisher("HBO");
            cd.setPubDate(LocalDate.now());
            cd.setDuration(10);
            cd.setTracks(2);
            em.persist(cd);

            DVD dvd = new DVD();
            dvd.setTitle("the wire");
            dvd.setAuthor("Dave Simmons");
            dvd.setPublisher("HBO");
            dvd.setPubDate(LocalDate.now());
            dvd.setDuration(10);
            dvd.setSubtitles(123);
            em.persist(dvd);


            tx.commit();
            System.out.println("objects saved");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
