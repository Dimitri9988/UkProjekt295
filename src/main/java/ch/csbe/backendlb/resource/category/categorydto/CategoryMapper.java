package ch.csbe.backendlb.resource.category.categorydto;

import ch.csbe.backendlb.resource.category.CategoryEntities;
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
