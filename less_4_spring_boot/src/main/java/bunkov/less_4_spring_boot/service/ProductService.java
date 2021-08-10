package bunkov.less_4_spring_boot.service;

import bunkov.less_4_spring_boot.controller.ProductListParams;
import bunkov.less_4_spring_boot.persist.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    List<Product> findAll();

    Page<Product> findWithFilter(ProductListParams productListParams);

    Optional<Product> findById(Long id);

    void save(Product product);

    void deleteById(Long id);
}
