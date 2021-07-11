package bunkov.first;

import bunkov.first.persist.Product;
import bunkov.first.persist.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype")
    public Product product(){
        return new Product();
    }

    @Bean
    public ProductRepository productRepository(){
        return new ProductRepository();
    }

    @Bean
    @Scope("prototype")//дз спринг 4
    public Cart cart(){
        return new Cart(productRepository());
    }

}
