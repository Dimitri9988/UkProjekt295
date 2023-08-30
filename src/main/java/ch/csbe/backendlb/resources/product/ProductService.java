package ch.csbe.backendlb.resources.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

         public List<ProductEntitie> ProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;

        public List<ProductEntitie> get() {
            return productRepository.findAll();
        }

        public getById(Long id) {
            return productRepository.findById(id).orElseThrow();
             }

        public ProductEntitie create(ProductEntitie product) {
            return productRepository.save(product);
        }

        public ProductEntitie update(long id, ProductEntitie product) {
            Optional<ProductEntitie> productOptional = productRepository.findbyId(id);
            if(productOptional.isPresent()) {
                ProductEntitie existingProduct = ProductOptional
                existingProduct.setName(product.getName());
            }
        }

        public void deleteById(Long id) {
            if(productRepository.exsisting)
             }
    }

}
