package bunkov;

import bunkov.entity.Contact;
import bunkov.entity.User;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Arrays;

public class Main06 {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = emFactory.createEntityManager();


        //Insert one to many
//        em.getTransaction().begin();
//
//        User user = new User(null, "user_with_contacts",25 );
//        Contact con1 = new Contact(null,"phone", "123124", user);
//        Contact con2 = new Contact(null,"address", "Land, USA", user);
//        Contact con3 = new Contact(null,"mail", "user@mail.ru", user);
//        user.addContact(con1);
//        user.addContact(con2);
//        user.addContact(con3);
//
//        em.persist(user);
//
//        em.getTransaction().commit();


        //Select


       // System.out.println(em.createQuery("select u from User u", User.class).getResultList());

//        User user = em.find(User.class, 10L);

        User user = em.createQuery("select u from User u join fetch u.contacts where u.id = :id", User.class)
                .setParameter("id", 10L)
                .getSingleResult();

        System.out.println(user);
        user.getContacts().forEach(System.out::println);

        em.close();
    }
}
