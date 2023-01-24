package exercise06_06;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveOrganisation {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Organisation organisation = new Organisation();
            organisation.setName("juvo");
            Member member = new Member();
            member.setName("onur");
            organisation.getMembers().add(member);
            Member member1 = new Member();
            member1.setName("runo");
            organisation.getMembers().add(member1);
            member.getOrganisations().add(organisation);
            member1.getOrganisations().add(organisation);
            em.persist(organisation);
            tx.commit();
            System.out.println("organisation and members saved");

        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}
