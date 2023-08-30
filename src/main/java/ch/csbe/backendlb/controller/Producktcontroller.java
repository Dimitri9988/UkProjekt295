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

    @GetMapping("{id}")
    public String getProductByid(@PathVariable String id){
        return "hier währe mein produckt mit der id = " + id;
    }

    @PutMapping("{id}")
    public String putProductByid(@PathVariable String id) { return "hier währe mein aktualisirtes produckt mit der id = " + id;
    }

    @DeleteMapping("{id}")
    public ProductEntitie deleteById(@RequestBody Long id) {
        return productService.deleteById(id);
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
