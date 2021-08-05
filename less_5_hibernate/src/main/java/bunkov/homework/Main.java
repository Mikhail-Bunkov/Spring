package bunkov.homework;

import bunkov.homework.entity.Buyer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductDao productDao = context.getBean("productDao", ProductDao.class);
        BuyerDao buyerDao = context.getBean("buyerDao", BuyerDao.class);


        System.out.println(buyerDao.findById(4).get());
        System.out.println(productDao.findById(8).get());


//        EntityManagerWorker entityManagerWorker = new EntityManagerWorker();
//        ProductDao productDao = new ProductDao(entityManagerWorker);
//        BuyerDao buyerDao = new BuyerDao(entityManagerWorker);
//        buyerDao.findAll().forEach(System.out::println);

    }
}
