package ch.csbe.backendlb.controller;

import ch.csbe.backendlb.resources.product.ProductEntitie;
import ch.csbe.backendlb.resources.product.ProductService;
import ch.csbe.backendlb.resources.product.productdto.ProductDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class Producktcontroller {

    @Autowired ProductService productService;

    @GetMapping("/{id}")
    public ProductDetailDto getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PutMapping("/{id}")
    public ProductDetailDto update(@RequestBody ProductEntitie product,@PathVariable Long id) {
        return  productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PostMapping("")
    public ProductDetailDto create(@RequestBody ProductEntitie product) {
        return productService.create(product);
    }

    @GetMapping("")
    public List<ProductDetailDto> get() {
        return productService.get();
    }

}
