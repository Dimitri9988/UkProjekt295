package ch.csbe.backendlb.resource.category.categorydto;

import ch.csbe.backendlb.resource.category.CategoryEntities;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {
    // wandelt CategoryCreateDto Objekt in ein CategoryEntities Objekt um.
    @Mapping(target = "name", source = "name")
    @Mapping(target = "active", source = "active")
    public abstract CategoryEntities toEntity(CategoryCreateDto categoryCreateDto);

    // wandelt CategoryEntities Objekt in ein CategoryShowDto Objekt um.
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "active", source = "active")
    public abstract CategoryShowDto toShowDto(CategoryEntities categoryEntities);

    // wandelt CategoryEntities Objekt in ein CategoryDetailDto Objekt um.
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "active", source = "active")
    public abstract CategoryDetailDto toDetailDto(CategoryEntities categoryEntities);

    // aktualisiert CategoryEntities Objekt mit den Werten aus CategoryUpdateDto Objekt.
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "active", source = "active")
    public abstract void update(CategoryUpdateDto categoryUpdateDto, @MappingTarget CategoryEntities categoryEntitiesToUpdate);
}