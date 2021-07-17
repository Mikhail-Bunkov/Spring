package bunkov.first;

import bunkov.first.persist.Product;
import bunkov.first.persist.ProductRepositoryImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//дз по спрингу 3
public class ConsoleProductController {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductRepositoryImp productRepository = context.getBean("productRepository", ProductRepositoryImp.class);
        Cart cart = context.getBean("cart", Cart.class);
        //дз спринг 1
        Product product1 = new Product(1L,"product1",100);
        Product product2 = new Product(2L,"product2",200);
        Product product3 = new Product(3L,"product3",300);
        Product product4 = new Product(4L,"product4",400);
        Product product5 = new Product(5L,"product5",500);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        cart.add(3L);
        cart.showCart();



    }
}
