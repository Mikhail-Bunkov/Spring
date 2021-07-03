package bunkov.first;

import bunkov.first.persist.Product;
import bunkov.first.persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

	private ProductRepository productRepository;

	@Override
	public void init() throws ServletException {
		 productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<Product> products = productRepository.findAll();
		resp.getWriter().println("<table>");
		for (Product p : products) {
			resp.getWriter().println("<tr><td>"+p.getId()+"</td><td>"+p.getName()+"</td></tr>");
		}
		resp.getWriter().println("</table>");
	}
}
