package ch.csbe.backendlb.resources.user.userdto;

import ch.csbe.backendlb.resources.product.ProductEntitie;
import ch.csbe.backendlb.resources.product.productdto.ProductCreateDto;
import ch.csbe.backendlb.resources.product.productdto.ProductDetailDto;
import ch.csbe.backendlb.resources.product.productdto.ProductShowDto;
import ch.csbe.backendlb.resources.product.productdto.ProductUpdateDto;
import ch.csbe.backendlb.resources.user.UserEntitie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "birthday", source = "birthday")
    @Mapping(target = "authenticated", source = "authenticated")
    public abstract UserEntitie toEntity(UserCreateDto userCreateDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "birthday", source = "birthday")
    @Mapping(target = "authenticated", source = "authenticated")
    public abstract UserShowDto toShowDto(UserEntitie userEntitie);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "birthday", source = "birthday")
    @Mapping(target = "authenticated", source = "authenticated")
    public abstract UserDetailDto toDetailDto(UserEntitie userEntitie);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "birthday", source = "birthday")
    @Mapping(target = "authenticated", source = "authenticated")
    public abstract void update(UserUpdateDto userUpdateDto, @MappingTarget UserEntitie userEntitieToUpdate);


}
