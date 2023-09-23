package ch.csbe.backendlb.resource.user.userdto;

import ch.csbe.backendlb.resource.user.UserEntitie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

// Mapper Klasse zur Umwandlung von verschidenen Benutzer DTOs und Benutzer Entitis
@Mapper(componentModel = "spring")
public abstract class UserMapper {

    // wandelt UserCreateDto in ein PUserEntitie um
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "birthday", source = "birthday")
    @Mapping(target = "authenticated", source = "authenticated")
    public abstract UserEntitie toEntity(UserCreateDto userCreateDto);

    // wandelt UserEntitie in ein UserShowDto um
    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "birthday", source = "birthday")
    @Mapping(target = "authenticated", source = "authenticated")
    public abstract UserShowDto toShowDto(UserEntitie userEntitie);

    // wandelt UserEntitie in ein UserDetailDto um
    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "birthday", source = "birthday")
    @Mapping(target = "authenticated", source = "authenticated")
    public abstract UserDetailDto toDetailDto(UserEntitie userEntitie);

    // versucht vorhandenes UserEntitie anhand von UserUpdateDto zu aktualisiren
    @Mapping(target = "firstName", source = "firstName", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "lastName", source = "lastName", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "username", source = "username", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "email", source = "email", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "password", source = "password", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "birthday", source = "birthday", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "authenticated", source = "authenticated", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(UserUpdateDto userUpdateDto, @MappingTarget UserEntitie userEntitieToUpdate);

}
