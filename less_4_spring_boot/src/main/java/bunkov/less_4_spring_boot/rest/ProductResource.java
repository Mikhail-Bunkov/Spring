package bunkov.less_4_spring_boot.rest;

import bunkov.less_4_spring_boot.controller.NotFoundException;
import bunkov.less_4_spring_boot.persist.Product;
import bunkov.less_4_spring_boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductResource {

    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Product findById(@PathVariable("id") Long id){
        return productService.findById(id).orElseThrow(()-> new NotFoundException("Product not found") );
    }

    @PostMapping(produces = "application/json")
    public Product create(@RequestBody Product product){
        if(product.getId() != null){
            throw new BadRequestException("Product Id should be null");
        }
        productService.save(product);
        return product;
    }

    @PutMapping(produces = "application/json")
    public void update(@RequestBody Product product){
        if(product.getId() == null){
            throw new BadRequestException("Product Id shouldn't be null");
        }
        productService.save(product);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public void detele(@PathVariable("id") Long id){
        productService.deleteById(id);
    }
}
