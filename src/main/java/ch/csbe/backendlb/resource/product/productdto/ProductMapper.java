package ch.csbe.backendlb.resource.product.productdto;

import ch.csbe.backendlb.resource.product.ProductEntitie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public abstract class ProductMapper {

        @Mapping(target = "sku", source = "sku")
        @Mapping(target = "active", source = "active")
        @Mapping(target = "name", source = "name")
        @Mapping(target = "images", source = "images")
        @Mapping(target = "description", source = "description")
        @Mapping(target = "prise", source = "prise")
        @Mapping(target = "stock", source = "stock")
        public abstract ProductEntitie toEntity(ProductCreateDto productCreateDto);

        @Mapping(target = "id", source = "id")
        @Mapping(target = "sku", source = "sku")
        @Mapping(target = "active", source = "active")
        @Mapping(target = "name", source = "name")
        @Mapping(target = "images", source = "images")
        @Mapping(target = "description", source = "description")
        @Mapping(target = "prise", source = "prise")
        @Mapping(target = "stock", source = "stock")
        public abstract ProductShowDto toShowDto(ProductEntitie productEntitie);

        @Mapping(target = "id", source = "id")
        @Mapping(target = "sku", source = "sku")
        @Mapping(target = "active", source = "active")
        @Mapping(target = "name", source = "name")
        @Mapping(target = "images", source = "images")
        @Mapping(target = "description", source = "description")
        @Mapping(target = "prise", source = "prise")
        @Mapping(target = "stock", source = "stock")
        public abstract ProductDetailDto toDetailDto(ProductEntitie productEntitie);

        @Mapping(target = "id", source = "id")
        @Mapping(target = "sku", source = "sku")
        @Mapping(target = "active", source = "active")
        @Mapping(target = "name", source = "name")
        @Mapping(target = "images", source = "images")
        @Mapping(target = "description", source = "description")
        @Mapping(target = "prise", source = "prise")
        @Mapping(target = "stock", source = "stock")
        public abstract void update(ProductUpdateDto productUpdateDto, @MappingTarget ProductEntitie productEntitieToUpdate);

    }

