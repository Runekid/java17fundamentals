package exercise06_03;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMenu {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Menu menu = new Menu();
            menu.setTitle("Back in black");
            menu.getIngredients().add(new Ingredient(1, "apple"));
            em.persist(menu);
            tx.commit();

        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}
