package bunkov.first;

import bunkov.first.persist.Product;
import bunkov.first.persist.ProductRepositoryImp;

import java.util.HashMap;
import java.util.Map;


//дз по спрингу 2
public class Cart {

    private final ProductRepositoryImp productRepository;

    private final Map<Long, Product> productMap = new HashMap<>();

    public Cart(ProductRepositoryImp productRepository) {
        this.productRepository = productRepository;
    }

    public void add(Long id){
        productMap.put(id, productRepository.findById(id));
    }

    public void delete(long id){
        productMap.remove(id);
    }

    public void showCart(){
        productMap.values().forEach(System.out::println);
    }

}
