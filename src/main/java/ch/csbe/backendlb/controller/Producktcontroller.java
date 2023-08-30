package ch.csbe.backendlb.controller;

import ch.csbe.backendlb.resources.product.ProductEntitie;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class Producktcontroller {

    @GetMapping("{id}")
    public String getProductByid(@PathVariable String id){
        return "hier währe mein produckt mit der id = " + id;
    }

    @PutMapping("{id}")
    public String putProductByid(@PathVariable String id) { return "hier währe mein aktualisirtes produckt mit der id = " + id;
    }

    @DeleteMapping("{id}")
    public String deleteProductByid(@PathVariable String id) { return "hier wird mein produckt mit der id = " + id + " gelöscht";
    }

    @PostMapping("")
    public ProductEntitie create(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping("")
    public String getProducts(){ return "hier währen mein produckte ";
    }

}
