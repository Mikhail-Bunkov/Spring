package bunkov.less_4_spring_boot.persist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepositoryImp extends JpaRepository<Product, Long> {

    List<Product> findByNameStartsWith(String prefix);
    List<Product> findProductByCostBetween(Integer min, Integer max);
}
