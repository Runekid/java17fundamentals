package exercise05_02;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestMessage {
    private static EntityManagerFactory emf;
    private static void print(int pos, Message memMessage) {
        EntityManager em = emf.createEntityManager();
        Message dbMessage = em.find(Message.class, memMessage.getId());
        em.close();
        System.out.println(pos + ": " + memMessage.getText() + "\t" + ((dbMessage != null) ? dbMessage.getText() : "null"));
    }

    public static void main(String[] args) {
        EntityManager em = null;
        try {

            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();

            EntityTransaction tx = em.getTransaction();
            //We remove existing record
            tx.begin();
            Message m = em.find(Message.class, 100L);
            if (m != null) em.refresh(m);
            tx.commit();

            //Test begins here
            tx.begin();
            m = new Message(100, "AAA");
                            //expected -> pos: objectMessage databank || actual -> objectMessage databank
            print(1,m); //exp -> 1: AAA    AAA || act -> 1: AAA    null  (I thought a find did an implicit commit, this issue kind of derailed the whole exercise for me)
            em.persist(m);
            tx.commit();
            print(2,m); //exp -> 2: AAA    AAA || act -> 2: AAA    AAA
            m.setText("BBB");
            tx.begin();
            em.refresh(m);
            print(3, m); //exp -> 3: BBB    AAA || act -> 3: AAA    AAA
            em.detach(m);
            m.setText("CCC");
            print(4,m); //exp -> 4: CCC    AAA || act -> 4: CCC    AAA
            tx.commit();
            print(5,m); //exp -> 5: CCC    AAA || act -> 5: CCC    AAA
            tx.begin();
            m = em.merge(m);
            print(6,m); //exp -> 6: CCC    CCC || act -> 6: CCC    AAA
            tx.commit();
            print(7,m); //exp -> 7: CCC    CCC || act -> 7: CCC    CCC
            em.clear();
            m.setText("DDD");
            print(8,m); //exp -> 8: DDD    CCC || act -> 8: DDD    CCC
            tx.begin();
            tx.commit();
            print(9,m); //exp -> 9: DDD    CCC || act -> 9: DDD    CCC
            m = em.find(Message.class, 100L);
            print(10, m); //exp -> 10: CCC    CCC || act -> 10: CCC    CCC
            m.setText("EEE");
            print(11, m); //exp -> 11: EEE    EEE || act -> 11: EEE    CCC
            tx.begin();
            tx.commit();
            m.setText("FFF");
            tx.begin();
            em.flush();
            m.setText("GGG");
            print(12,m); //exp -> 12: GGG    GGG || act -> 12: GGG    EEE (flush does a commit but m is unmanaged, I didn't realize m was unmanaged)
            em.refresh(m);
            print(13, m); //exp -> 13: GGG    GGG || act -> 13: FFF    EEE (GGG change is lost)
            tx.rollback();
            print(14,m); //exp -> 14: GGG    EEE || act -> 14: FFF    EEE (message is unmanaged again)
            tx.begin();
            m.setText("HHH");
            print(15, m); //exp -> 15: HHH    HHH || act -> 15: HHH   EEE
            tx.commit();
            print(16,m); //exp -> 16: HHH    HHH || act -> 16: HHH    EEE (message is still unmanaged)
            tx.begin();
            m = em.merge(m);
            print(17,m); //exp -> 17: HHH    HHH || act -> 17: HHH    EEE (message is not committed)
            tx.commit();
            print(18,m); //exp -> 18: HHH    HHH || act -> 18: HHH    HHH (message is committed)
            em.close();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
