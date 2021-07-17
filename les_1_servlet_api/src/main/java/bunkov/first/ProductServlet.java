package bunkov.first;

import bunkov.first.persist.Product;
import bunkov.first.persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {

	String localhostAddress ="http://31.31.201.222:8080";
	private ProductRepository productRepository;

	@Override
	public void init() throws ServletException {
		 productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<Product> products = productRepository.findAll();

		PrintWriter wr = resp.getWriter();

		if(req.getPathInfo()==null) {

			wr.println();

			wr.println("<table>");
			for (Product p : products) {
				wr.println("<tr><td>"+ p.getId() + "</td><td><a href="+localhostAddress+req.getContextPath()+req.getServletPath()+"/"+p.getId()+">" + p.getName() + "</a></td></tr>");//дз сервлет 2
			}
			wr.println("</table>");
		}else{
			//дз сервлет 1
			String pathInfo = req.getPathInfo();
			StringBuilder sb = new StringBuilder();
			sb.append(pathInfo);
			sb.delete(0,1);

			long id = Long.parseLong(sb.toString());
			wr.println(productRepository.findById(id).getName());

		}
	}
}
