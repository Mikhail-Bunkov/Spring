package bunkov.homework;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("bunkov.homework")
public class AppConfig {


    @Bean
    @Scope("prototype")
    public EntityManagerWorker entityManagerWorker(){
        return new EntityManagerWorker();
    }
    @Bean
    public ProductDao productDao(){
        return new ProductDao(entityManagerWorker());
    }

    @Bean
    public BuyerDao buyerDao(){
        return new BuyerDao(entityManagerWorker());
    }

}
