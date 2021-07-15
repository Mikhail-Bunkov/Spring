package bunkov.first;

import bunkov.first.persist.Product;
import bunkov.first.persist.ProductRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootstrapListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();

		ProductRepository productRepository = new ProductRepository();
		productRepository.save(new Product(1L, "Киви", 11));
		productRepository.save(new Product(2L, "Арбуз",52));
		productRepository.save(new Product(3L, "Яблоко",2));

		sc.setAttribute("productRepository", productRepository);
	}
}
