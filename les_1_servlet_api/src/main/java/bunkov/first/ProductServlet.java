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

	private ProductRepository productRepository;

	@Override
	public void init() throws ServletException {
		 productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<Product> products = productRepository.findAll();

		PrintWriter wr = resp.getWriter();

//		if(req.getPathInfo()==null) {
//
//			wr.println();
//
//			wr.println("<table>");
//			for (Product p : products) {
//				wr.println("<tr><td>" + p.getId() + "</td><td>" + p.getName() + "</td></tr>");
//			}
//			wr.println("</table>");
//		}else{
//			wr.println("<h1>Оппачки</h1>");
//			String pathInfo = req.getPathInfo();
//			StringBuilder sb = new StringBuilder();
//			sb.append(pathInfo);
//			sb.delete(0,1);
//
//			long id = Long.parseLong(sb.toString());
//			wr.println(productRepository.findById(id).getName());
//			wr.println("<h2>"+id+" - это</h2>");
//
//		}
	}
}
