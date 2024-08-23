package dev.ruchir.notes_lake.mapper;

import dev.ruchir.notes_lake.dto.NoteSharingDTO;
import dev.ruchir.notes_lake.model.Core.NoteSharing;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NoteSharingMapper {

    NoteSharingMapper INSTANCE = Mappers.getMapper(NoteSharingMapper.class);

    @Mapping(source = "handwrittenNote.id", target = "handwrittenNoteId")
    @Mapping(source = "typedNote.id", target = "typedNoteId")
    @Mapping(source = "user.id", target = "userId")
    NoteSharingDTO toNoteSharingDTO(NoteSharing noteSharing);

    @Mapping(source = "handwrittenNoteId", target = "handwrittenNote.id")
    @Mapping(source = "typedNoteId", target = "typedNote.id")
    @Mapping(source = "userId", target = "user.id")
    NoteSharing toNoteSharingEntity(NoteSharingDTO noteSharingDTO);
}
