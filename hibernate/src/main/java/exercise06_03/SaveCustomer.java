package exercise06_03;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveCustomer {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Customer customer = new Customer();
            customer.setName("onur");
            customer.getPhones().put("home", "0484569581");
            customer.getPhones().put("work", "0485130125");
            customer.getEmails().put(EmailType.HOME, new Email("onur.bugdayci@juvo.be"));
            customer.getEmails().put(EmailType.BUSINESS, new Email("bugdayci.onur@aol.com"));
            em.persist(customer);
            tx.commit();

        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}
