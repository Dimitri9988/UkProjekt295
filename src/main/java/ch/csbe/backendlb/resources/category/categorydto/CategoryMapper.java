package ch.csbe.backendlb.resources.category.categorydto;

import ch.csbe.backendlb.resources.category.CategoryEntities;
import ch.csbe.backendlb.resources.product.ProductEntitie;
import ch.csbe.backendlb.resources.product.productdto.ProductCreateDto;
import ch.csbe.backendlb.resources.product.productdto.ProductDetailDto;
import ch.csbe.backendlb.resources.product.productdto.ProductShowDto;
import ch.csbe.backendlb.resources.product.productdto.ProductUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "active", source = "active")

    public abstract CategoryEntities toEntity(CategoryCreateDto categoryCreateDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "active", source = "active")
    public abstract CategoryShowDto toShowDto(CategoryEntities categoryEntities);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "active", source = "active")
    public abstract CategoryDetailDto toDetailDto(CategoryEntities categoryEntities);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "active", source = "active")
    public abstract void update(CategoryUpdateDto categoryUpdateDto, @MappingTarget CategoryEntities categoryEntitiesToUpdate);

}
