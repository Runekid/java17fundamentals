package be.onurbugdayci.beers.services;

import be.onurbugdayci.beers.dao.BeerDao;
import be.onurbugdayci.beers.domain.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository("beerRepository")
public class BeerRepositoryImpl implements BeerRepository {
    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public Beer getBeerById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Beer beer = em.find(Beer.class, id);
            tx.commit();
            return beer;

        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public List<Beer> getBeerByAlcohol(float alcohol) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            TypedQuery<Beer> query = em.createQuery("select b from Beer b where b.alcohol = ?1", Beer.class);
            query.setParameter(1, alcohol);
            tx.begin();
            List<Beer> beers = query.getResultList();
            tx.commit();
            return beers;

        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public void updateBeer(Beer b) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {

            tx.begin();
            em.merge(b);
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            if (em != null) em.close();
        }
    }
}
