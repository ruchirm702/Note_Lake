package dev.ruchir.notes_lake.mapper;

import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.dto.TypedNoteDTO;
import dev.ruchir.notes_lake.model.Core.HandwrittenNote;
import dev.ruchir.notes_lake.model.Core.TypedNote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    @Mapping(source = "tags", target = "tags")
    HandwrittenNoteDTO toHandwrittenNoteDTO(HandwrittenNote handwrittenNote);

    @Mapping(source = "tags", target = "tags")
    HandwrittenNote toHandwrittenNoteEntity(HandwrittenNoteDTO handwrittenNoteDTO);

    @Mapping(source = "tags", target = "tags")
    TypedNoteDTO toTypedNoteDTO(TypedNote typedNote);

    @Mapping(source = "tags", target = "tags")
    TypedNote toTypedNoteEntity(TypedNoteDTO typedNoteDTO);
}
