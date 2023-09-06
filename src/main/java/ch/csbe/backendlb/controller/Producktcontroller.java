package ch.csbe.backendlb.controller;

import ch.csbe.backendlb.resources.product.ProductEntitie;
import ch.csbe.backendlb.resources.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class Producktcontroller {

    @Autowired ProductService productService;

    @GetMapping("/{id}")
    public ProductEntitie getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PutMapping("/{id}")
    public ProductEntitie update(@RequestBody ProductEntitie product,@PathVariable Long id) {
        return  productService.update(id, product );
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PostMapping("")
    public ProductEntitie create(@RequestBody ProductEntitie product) {
        return productService.create(product);
    }

    @GetMapping("")
    public List<ProductEntitie> get() {
        return productService.get();
    }

}
