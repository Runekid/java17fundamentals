package exercise07_01;

import javax.persistence.*;

public class GetBeer {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            /*TypedQuery<Beer> query = em.createQuery("select b from Beer as b", Beer.class);
            query.setMaxResults(20);
            query.getResultStream().forEach(System.out::println);*/

            TypedQuery<Beer> query = em.createNamedQuery("findAllBeers", Beer.class);
            query.setMaxResults(20);
            query.getResultStream().forEach(System.out::println);
        } finally {
            if (em != null)
                em.close();
            if (emf != null)
                emf.close();
        }
    }
}
