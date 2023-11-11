package az.baxtiyargil.demoldapsecurity.component.mapper;

import az.baxtiyargil.demoldapsecurity.model.dto.request.CreateUserRequestDto;
import org.keycloak.representations.idm.UserRepresentation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "enabled", source = "enabled")
    UserRepresentation toUserRepresentation(CreateUserRequestDto requestDto);

}
