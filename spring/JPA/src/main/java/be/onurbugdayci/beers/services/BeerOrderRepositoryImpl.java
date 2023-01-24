package be.onurbugdayci.beers.services;

import be.onurbugdayci.beers.domain.Beer;
import be.onurbugdayci.beers.domain.BeerOrder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository("beerOrderRepository")
public class BeerOrderRepositoryImpl implements BeerOrderRepository{

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public int saveOrder(BeerOrder beerOrder) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {

            tx.begin();
            em.persist(beerOrder);
            tx.commit();
            return beerOrder.getId();

        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public BeerOrder getBeerOrderById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            BeerOrder beerOrder = em.find(BeerOrder.class, id);
            tx.commit();
            return beerOrder;

        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            if (em != null) em.close();
        }
    }
}
