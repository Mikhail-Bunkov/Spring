package bunkov.less_4_spring_boot.controller;

import bunkov.less_4_spring_boot.persist.Product;
import bunkov.less_4_spring_boot.persist.ProductRepositoryImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public String listPage(Model model,
                           @RequestParam("productNameFilter")Optional<String> productNameFilter,
                           @RequestParam("productMinCostFilter")Optional<Integer> productMinCostFilter,
                           @RequestParam("productMaxCostFilter")Optional<Integer> productMaxCostFilter) {

        logger.info("Product list page requested");


        List<Product> products = productRepository.filterProducts(productNameFilter.orElse(null),
                productMinCostFilter.orElse(null),
                productMaxCostFilter.orElse(null));


//        List<Product> products = productNameFilter
//                .map(productRepository::findByNameStartsWith)
//                .orElseGet(productRepository::findAll);
//
//
//        if(productMinCostFilter.isPresent() && productMaxCostFilter.isPresent()){
//            products = productRepository.findProductByCostBetween(productMinCostFilter.get(), productMaxCostFilter.get());
//        }

        model.addAttribute("products", products);
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
        return "product_form";
    }

    @PostMapping
    public String update(@Valid Product product, BindingResult result) {
        logger.info("Trying to saving product");

        if(result.hasErrors()){
            return "product_form";
        }

        productRepository.save(product);
        return "redirect:/product";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        productRepository.deleteById(id);
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
