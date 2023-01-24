package exercise06_03;

import exercise06_01.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class SaveAlbum {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Album album = new Album();
            album.setTitle("Back in black");
            album.setAuthor("ACDC");
            album.getTracks().add("song1");
            em.persist(album);
            tx.commit();

        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}
