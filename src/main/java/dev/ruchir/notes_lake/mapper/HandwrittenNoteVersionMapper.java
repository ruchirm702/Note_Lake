package dev.ruchir.notes_lake.mapper;

import dev.ruchir.notes_lake.dto.HandwrittenNoteVersionDTO;
import dev.ruchir.notes_lake.model.Core.HandwrittenNoteVersion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface HandwrittenNoteVersionMapper {

    HandwrittenNoteVersionMapper INSTANCE = Mappers.getMapper(HandwrittenNoteVersionMapper.class);

    HandwrittenNoteVersionDTO toHandwrittenNoteVersionDTO(HandwrittenNoteVersion handwrittenNoteVersion);

    HandwrittenNoteVersion toHandwrittenNoteVersion(HandwrittenNoteVersionDTO handwrittenNoteVersionDTO);

    List<HandwrittenNoteVersionDTO> toHandwrittenNoteVersionDTOs(List<HandwrittenNoteVersion> versions);

    List<HandwrittenNoteVersion> toHandwrittenNoteVersions(List<HandwrittenNoteVersionDTO> versionDTOs);
}
