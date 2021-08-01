package bunkov.homework;

import bunkov.homework.entity.Buyer;
import bunkov.homework.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BuyerDao {

    private final EntityManagerWorker emFactory;

    @Autowired
    public BuyerDao(EntityManagerWorker emFactory) {
        this.emFactory = emFactory;
    }

    public List<Buyer> findAll(){
        return emFactory.executeForEntityManager(
                em -> em.createQuery("select b from Buyer b join fetch b.productList", Buyer.class).getResultList()
        );
    }

    public Optional<Buyer> findById(long id){
        return emFactory.executeForEntityManager(
                em -> Optional.ofNullable(em.createQuery("select b from Buyer b join fetch b.productList where b.id = :id", Buyer.class)
                .setParameter("id", id)
                .getSingleResult()
        ));

    }

    public void insert(Buyer buyer){
        emFactory.executeInTransaction(
                em -> em.persist(buyer)
        );
    }

    public void update(Buyer buyer){
        emFactory.executeInTransaction(
                em -> em.merge(buyer)
        );
    }

    public void delete(long id){
        emFactory.executeInTransaction(
                em -> em.createQuery("delete from Buyer where id = :id")
                        .setParameter("id",id)
                        .executeUpdate()
        );
    }
    public void save(Buyer buyer){
        if( buyer.getId()!=null){
            insert(buyer);
        }else{
            update(buyer);
        }
    }
}
