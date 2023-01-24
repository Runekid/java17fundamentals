package exercise06_03;

import exercise06_01.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetAlbum {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Album album = em.find(Album.class, 1L);
            System.out.println(album.toString());
            tx.commit();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
