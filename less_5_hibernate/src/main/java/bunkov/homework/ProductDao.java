package bunkov.homework;

import bunkov.homework.entity.Buyer;
import bunkov.homework.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
@Component
public class ProductDao {
    private final EntityManagerWorker emFactory;

    @Autowired
    public ProductDao(EntityManagerWorker emFactory) {
        this.emFactory = emFactory;
    }

    public List<Product> findAll(){
        return emFactory.executeForEntityManager(
                em -> em.createQuery("select p from Product p", Product.class).getResultList()
        );
    }

    public Optional<Product> findById(long id){
        return emFactory.executeForEntityManager(
                em -> Optional.ofNullable(em.createQuery("select p from Product p join fetch p.buyer where p.id = :id", Product.class)
                        .setParameter("id", id)
                        .getSingleResult()
                ));

    }

    public void insert(Product product){
        emFactory.executeInTransaction(
                em -> em.persist(product)
        );
    }

    public void update(Product product){
        emFactory.executeInTransaction(
                em -> em.merge(product)
        );
    }

    public void delete(long id){
        emFactory.executeInTransaction(
                em -> em.createQuery("delete from Product where id = :id")
                        .setParameter("id",id)
                        .executeUpdate()
        );
    }
    public void save(Product product){
        if( product.getId()!=null){
            insert(product);
        }else{
            update(product);
        }
    }


}
