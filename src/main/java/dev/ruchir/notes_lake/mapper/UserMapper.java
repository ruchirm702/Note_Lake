package dev.ruchir.notes_lake.mapper;

import dev.ruchir.notes_lake.dto.UserDTO;
import dev.ruchir.notes_lake.model.Core.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(User user);
    User toUserEntity(UserDTO userDTO);
}
