package bunkov.less_4_spring_boot.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepositoryImp extends JpaRepository<Product, Long> {

    List<Product> findByNameStartsWith(String prefix);
    List<Product> findProductByCostBetween(Integer min, Integer max);

    @Query("select p from Product p " +
            "where ( p.name like CONCAT(:prefix, '%') or :prefix is null) and " +
            "( p.cost >= :min or :min is null) and " +
            "( p.cost <= :max or :max is null)")
    List<Product> filterProducts(@Param("prefix") String prefix,
                                 @Param("min") Integer min,
                                 @Param("max") Integer max);

}
