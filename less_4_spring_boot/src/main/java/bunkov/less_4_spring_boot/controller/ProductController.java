package bunkov.less_4_spring_boot.controller;

import bunkov.less_4_spring_boot.persist.Product;
import bunkov.less_4_spring_boot.persist.ProductRepositoryImp;
import bunkov.less_4_spring_boot.persist.ProductSpecifications;
import bunkov.less_4_spring_boot.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String listPage(Model model,
                           ProductListParams productListParams){

        logger.info("Product list page requested");

//        Specification<Product> spec = Specification.where(null);
//        if(productNameFilter.isPresent()&&!productNameFilter.get().isBlank()){
//            spec = spec.and(ProductSpecifications.productNamePrefix(productNameFilter.get()));
//        }
//        if(productMinCostFilter.isPresent()){
//            spec = spec.and(ProductSpecifications.minCost(productMinCostFilter.get()));
//        }
//        if(productMaxCostFilter.isPresent()){
//            spec = spec.and(ProductSpecifications.maxCost(productMaxCostFilter.get()));
//        }





//        List<Product> products = productRepository.filterProducts(productNameFilter.orElse(null),
//                productMinCostFilter.orElse(null),
//                productMaxCostFilter.orElse(null));


//        List<Product> products = productNameFilter
//                .map(productRepository::findByNameStartsWith)
//                .orElseGet(productRepository::findAll);
//
//
//        if(productMinCostFilter.isPresent() && productMaxCostFilter.isPresent()){
//            products = productRepository.findProductByCostBetween(productMinCostFilter.get(), productMaxCostFilter.get());
//        }

       model.addAttribute("products", productService.findWithFilter(productListParams));

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

        model.addAttribute("product", productService.findById(id).orElseThrow(()-> new NotFoundException("Product not found")));
        return "product_form";
    }

    @PostMapping
    public String update(@Valid Product product, BindingResult result) {
        logger.info("Trying to saving product");

        if(result.hasErrors()){
            return "product_form";
        }

        productService.save(product);
        return "redirect:/product";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        productService.deleteById(id);
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
