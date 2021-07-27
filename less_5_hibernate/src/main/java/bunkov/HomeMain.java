package bunkov;

import bunkov.entity.Product;
import org.hibernate.cfg.Configuration;


import javax.persistence.EntityManagerFactory;
import java.util.List;


public class HomeMain {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        ProductDao productDao = new ProductDao(emFactory);

        List.of(
                new Product(null,"orange",200),
                new Product(null,"strawberry",190),
                new Product(null,"pineapple",450)
        ).forEach(productDao::update);
        Product product = new Product(null, "banana", 150);
        productDao.update(product);

        System.out.println(productDao.select(2L));
        productDao.closeEM();
    }
}
