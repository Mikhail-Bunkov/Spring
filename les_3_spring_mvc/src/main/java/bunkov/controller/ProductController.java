package bunkov.controller;

import bunkov.persist.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final ProductRepositoryImp productRepository;

    @Autowired
    public ProductController(ProductRepositoryImp productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String listPage(Model model) {
        logger.info("Product list page requested");

        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @GetMapping("/new")
    public String newProductForm(Model model) {
        logger.info("New product page requested");

        model.addAttribute("product", new Product());
        return "product_form";
    }

    @GetMapping("/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        Product product = productRepository.findById(id);
        model.addAttribute("product", new Product(product.getId(),product.getName(), product.getCost()));
        delete(id, model);


        return "product_form";
    }

    @PostMapping
    public String update(Product product) {
        logger.info("Trying to saving product");

        for (Product productFromRepository : productRepository.findAll() ) {
            if(product.getName().equals(productFromRepository.getName())){
                return "redirect:/product";
            }
        }

        logger.info("Saving product");

        productRepository.save(product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model){
        productRepository.delete(productRepository.findById(id).getId());
        return "redirect:/product";
    }
}
