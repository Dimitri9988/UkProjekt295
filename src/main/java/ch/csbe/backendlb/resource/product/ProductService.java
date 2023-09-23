package ch.csbe.backendlb.resource.product;

import ch.csbe.backendlb.resource.product.productdto.ProductDetailDto;
import ch.csbe.backendlb.resource.product.productdto.ProductUpdateDto;
import ch.csbe.backendlb.resource.product.productdto.ProductCreateDto;
import ch.csbe.backendlb.resource.product.productdto.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Ist verantwortlich für die Logikt für die Produkte
@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductRepository productRepository;

    // Ruft Details eines Produktes auf anhand der Id
    public ProductDetailDto getById(Long id) {

        ProductEntitie porductEntitie = this.productRepository.getById(id);

        ProductDetailDto productDetailDto = productMapper.toDetailDto(porductEntitie);
            return productDetailDto;
    }





    //Ruft alle Produkte auf und gibt sie zurück
    public List<ProductDetailDto> get() {
        return  productRepository.findAll().stream().map(productMapper::toDetailDto).collect(Collectors.toList());
    }


    // Erstellt ein neues Produkt mit den angegebenen daten
    public ProductDetailDto create(ProductCreateDto product) {

        return productMapper.toDetailDto(productRepository.save(productMapper.toEntity(product))) ;
    }

    // aktualisiert ein Produkt anhand der Id mit den mitgegebenen Daten
    public ProductDetailDto update(Long id, ProductUpdateDto product) {
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
            return productMapper.toDetailDto(productRepository.save(existingProduct));
        }
        return new ProductDetailDto();
    }

    // Löscht ein Produkt anhand der Id
    public void deleteById(Long id) {
        productRepository.deleteById(id);


    }
}
