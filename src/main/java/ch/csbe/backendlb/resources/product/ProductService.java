package ch.csbe.backendlb.resources.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public List<ProductEntitie> ProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntitie> get() {
        return productRepository.findAll();
    }

    public ProductEntitie getById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public ProductEntitie create(ProductEntitie product) {
        return productRepository.save(product);
    }

    public ProductEntitie update(Long id, ProductEntitie product) {
        Optional<ProductEntitie> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            ProductEntitie existingProduct = productOptional.get();
            existingProduct.setName(product.getName());
            existingProduct.setActive(product.getActive());
            existingProduct.setId(product.getId());
        }
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);


    }
}


