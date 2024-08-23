package dev.ruchir.notes_lake.mapper;

import dev.ruchir.notes_lake.dto.UserGroupDTO;
import dev.ruchir.notes_lake.model.Core.UserGroup;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserGroupMapper {

    UserGroupMapper INSTANCE = Mappers.getMapper(UserGroupMapper.class);

    @Mapping(source = "members", target = "members")
    @Mapping(source = "sharedHandwrittenNotes", target = "sharedHandwrittenNotes")
    @Mapping(source = "sharedTypedNotes", target = "sharedTypedNotes")
    UserGroupDTO toUserGroupDTO(UserGroup userGroup);

    @Mapping(source = "members", target = "members")
    @Mapping(source = "sharedHandwrittenNotes", target = "sharedHandwrittenNotes")
    @Mapping(source = "sharedTypedNotes", target = "sharedTypedNotes")
    UserGroup toUserGroupEntity(UserGroupDTO userGroupDTO);
}
