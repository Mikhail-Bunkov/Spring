package bunkov.less_4_spring_boot.controller;

import bunkov.less_4_spring_boot.persist.Product;
import bunkov.less_4_spring_boot.persist.ProductRepositoryImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
//        Product product = productRepository.findById(id);
        model.addAttribute("product", productRepository.findById(id).orElseThrow(()-> new NotFoundException("Product not found")));
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
        productRepository.delete(productRepository.findById(id).get().getId());
        return "redirect:/product";
    }

//    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ModelAndView notFoundExceptionHandler(NotFoundException ex){
        ModelAndView modelAndView = new ModelAndView("not_found");
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }
}
