package bunkov;

//import bunkov.entity.Product;
import org.hibernate.cfg.Configuration;


import javax.persistence.EntityManagerFactory;
import java.util.List;


public class HomeMain {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        ProductDao productDao = new ProductDao(emFactory);


    }
}
