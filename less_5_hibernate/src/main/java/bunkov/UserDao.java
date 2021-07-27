package bunkov;

import bunkov.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserDao {

    public UserDao(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();
    }

    private EntityManager em;
    
//    public void insert(User user){ //закомментил, так как есть метод update в котором используется merge()
//        em.getTransaction().begin();
//        em.persist(user);
//        em.getTransaction().commit();
//    }

    public User select(Long id){
        return em.find(User.class, id);
    }
    
    public void delete(Long id){
        em.getTransaction().begin();
        User user = em.getReference(User.class, id);
        em.remove(user);
        em.getTransaction().commit();
    }
    
    public void update(User user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    /**
     * @param id Впишите id юзера которого надо поменять. Всегда заполняемое поле;
     * @param age Впишите возраст, если нужно поменять, иначе укажите null;
     * @param username Впишите новое имя, если нужно, иначе укажите null;
     */
    public void update(Long id, Integer age, String username){ // тоже решил добавить, а почему бы и нет
        em.getTransaction();
        User user = em.find(User.class, id);
        if (age != null) {
            user.setAge(age);
        }
        if (username != null) {
            user.setUsername(username);
        }
        em.getTransaction().commit();
    }
}
