package ch.csbe.backendlb.controller;

        import ch.csbe.backendlb.resource.product.ProductService;
        import ch.csbe.backendlb.resource.product.productdto.ProductCreateDto;
        import ch.csbe.backendlb.resource.product.productdto.ProductDetailDto;
        import ch.csbe.backendlb.resource.product.productdto.ProductMapper;
        import ch.csbe.backendlb.resource.product.productdto.ProductUpdateDto;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/products")
public class ProducktController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    //Verarbeitet Get Anfrage und gibt Liste von Produkten zurück.
    @GetMapping("")
    public List<ProductDetailDto> get() {
        return productService.get();
    }

    //Verarbeited Get Anfrage Gibt Produkt zurück mit der passenden Id
    @GetMapping("/{id}")
    public ProductDetailDto getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    //Verarbeited Put Anfrage und aktualisirt ein Produckt anhand der Id
    @PutMapping("/{id}")
    public ProductDetailDto update(@RequestBody ProductUpdateDto product, @PathVariable Long id) {
        return productService.update(id, product);
    }

    //Verarbeited Delet Anfrage und Löscht Produkt anhand der Id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    // Verarbeited Psot Anfrage und erstelt Produkt
    @PostMapping("")
    public ProductDetailDto create(@RequestBody ProductCreateDto product) {
        return productService.create(product);
    }
}