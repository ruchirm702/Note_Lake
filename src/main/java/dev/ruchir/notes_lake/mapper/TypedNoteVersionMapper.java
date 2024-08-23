package dev.ruchir.notes_lake.mapper;

import dev.ruchir.notes_lake.dto.TypedNoteVersionDTO;
import dev.ruchir.notes_lake.model.Core.TypedNoteVersion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface TypedNoteVersionMapper {

    TypedNoteVersionMapper INSTANCE = Mappers.getMapper(TypedNoteVersionMapper.class);

    TypedNoteVersionDTO toTypedNoteVersionDTO(TypedNoteVersion typedNoteVersion);

    TypedNoteVersion toTypedNoteVersion(TypedNoteVersionDTO typedNoteVersionDTO);

    List<TypedNoteVersionDTO> toTypedNoteVersionDTOs(List<TypedNoteVersion> versions);

    List<TypedNoteVersion> toTypedNoteVersions(List<TypedNoteVersionDTO> versionDTOs);
}
