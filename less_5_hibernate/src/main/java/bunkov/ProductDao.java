package bunkov;

import bunkov.entity.Product;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ProductDao {
    private EntityManager em;

    public ProductDao(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();
    }

    public Product select(Long id){
        return em.find(Product.class, id);
    }

    public void delete(Long id){
        em.getTransaction().begin();
        Product product = em.getReference(Product.class, id);
        em.remove(product);
        em.getTransaction().commit();
    }

    public void update(Product product){
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
    }

//    public void persist(Product product){
//        em.getTransaction().begin();
//        em.persist(product);
//        em.getTransaction().commit();
//    }
    public void closeEM(){
        em.close();
    }

    /**
     * @param id Впишите id продукта которого надо поменять. Всегда заполняемое поле;
     * @param name Впишите новое имя, если нужно поменять, иначе укажите null;
     * @param cost Впишите новую цену, если нужно, иначе укажите null;
     */
    public void update(Long id,String name, Integer cost){ // тоже решил добавить, а почему бы и нет
        em.getTransaction();
        Product product = em.find(Product.class, id);
        if (cost != null) {
            product.setCost(cost);
        }
        if (name != null) {
            product.setName(name);
        }
        em.getTransaction().commit();
    }
}
