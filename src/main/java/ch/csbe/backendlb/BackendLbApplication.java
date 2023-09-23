package ch.csbe.backendlb;

import ch.csbe.backendlb.resource.product.productdto.ProductMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class BackendLbApplication {


    ProductMapper productMapper;

    public static void main(String[] args) {
        SpringApplication.run(BackendLbApplication.class, args);
    }

    @Bean
    @Primary
    public ProductMapper productMapper() {
        if(productMapper == null) {
            productMapper = Mappers.getMapper(ProductMapper.class);
        }
        return productMapper;
    }

}
