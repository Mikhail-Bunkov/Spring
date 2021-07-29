package bunkov.homework;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.function.Consumer;
import java.util.function.Function;

public class EntityManagerWorker {

    private EntityManagerFactory emFactory;

    public EntityManagerWorker(EntityManagerFactory emFactory) {
        this.emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();;
    }

    private <R> R executeForEntityManager(Function<EntityManager, R> function){
        EntityManager em = emFactory.createEntityManager();
        try{
            return function.apply(em);
        }finally {
            em.close();
        }
    }

    private void executeInTransaction(Consumer<EntityManager> consumer){
        EntityManager em = emFactory.createEntityManager();
        try{
            em.getTransaction().begin();
            consumer.accept(em);
            em.getTransaction().commit();
        }catch (Exception exception){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    public EntityManagerFactory getEntityManagerFactory() {
    }
}
