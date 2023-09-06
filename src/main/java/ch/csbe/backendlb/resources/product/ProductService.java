package ch.csbe.backendlb.resources.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;



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
            existingProduct.setSku(product.getSku());
            existingProduct.setImages(product.getImages());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrise(product.getPrise());
            existingProduct.setStock(product.getStock());
            return productRepository.save(existingProduct);
        }
        return new ProductEntitie();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);


    }
}


