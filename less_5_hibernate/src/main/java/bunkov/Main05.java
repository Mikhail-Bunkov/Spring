package bunkov;

import bunkov.entity.User;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main05 {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = emFactory.createEntityManager();


        //INSERT

        em.getTransaction().begin();

//        List<User> users = List.of(
//                new User(null, "user1", 25),
//                new User(null, "user2", 15),
//                new User(null, "user3", 27),
//                new User(null, "user4", 32)
//
////        );
//        List.of(
//                new User(null, "user1", 25),
//                new User(null, "user2", 15),
//                new User(null, "user3", 27),
//                new User(null, "user4", 32)
//
//        ).forEach(em::persist);
//
//
//        em.getTransaction().commit();


        //SELECT

//        User user = em.find(User.class, 1L);
//        System.out.println(user);


//        //HQL, JPQL
//        List<User> users = em.createQuery("select u from User u where u.age< :age", User.class).setParameter("age", 25).getResultList();
//        System.out.println(users);
//
//        Long countUsers = em.createNamedQuery("countUsers", Long.class).getSingleResult();
//        System.out.println(countUsers);
//
//        users = em.createNativeQuery("select * from users", User.class).getResultList();
//        System.out.println(users);


        // UPDATE


//        em.createQuery("update User set age = 22 where id = 1").executeUpdate();


//        User user = em.find(User.class, 2L);
//        user.setAge(27);

//
//        User user = new User(1L, "user1", 62);
//        em.merge(user);
//        em.getTransaction().commit();



        //DELETE

//        User user = em.find(User.class, 5L);
        User user = em.getReference(User.class, 4L);//более производительный вариант метода find, для удаления принято его использовать
        em.remove(user);
        em.getTransaction().commit();


        //закрывать надо
        em.close();
    }
}
