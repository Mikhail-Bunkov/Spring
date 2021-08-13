package bunkov.less_4_spring_boot.service;

import bunkov.less_4_spring_boot.controller.ProductListParams;
import bunkov.less_4_spring_boot.persist.Product;
import bunkov.less_4_spring_boot.persist.ProductRepositoryImp;
import bunkov.less_4_spring_boot.persist.ProductSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceIml implements ProductService {

    private final ProductRepositoryImp productRepository;

    @Autowired
    public ProductServiceIml(ProductRepositoryImp productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findWithFilter(ProductListParams productListParams ) {
        Specification<Product> spec = Specification.where(null);

        if(productListParams.getProductNameFilter()!=null&&!productListParams.getProductNameFilter().isBlank()){
            spec=spec.and(ProductSpecifications.productNamePrefix(productListParams.getProductNameFilter()));
        }

        if(productListParams.getProductMinCostFilter()!=null){
            spec = spec.and(ProductSpecifications.minCost(productListParams.getProductMinCostFilter()));
        }
        if(productListParams.getProductMaxCostFilter()!=null){
            spec = spec.and(ProductSpecifications.maxCost(productListParams.getProductMaxCostFilter()));
        }

        return productRepository.findAll(spec,
                PageRequest.of(Optional.ofNullable(productListParams.getPage()).orElse(1)-1,
                        Optional.ofNullable(productListParams.getSize()).orElse(3),
                        Sort.by(Optional.ofNullable(productListParams.getSortField()).orElse("id"))));
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
