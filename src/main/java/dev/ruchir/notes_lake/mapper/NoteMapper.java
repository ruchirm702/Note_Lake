package dev.ruchir.notes_lake.mapper;

import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.dto.TypedNoteDTO;
import dev.ruchir.notes_lake.model.Core.HandwrittenNote;
import dev.ruchir.notes_lake.model.Core.TypedNote;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    HandwrittenNoteDTO toHandwrittenNoteDTO(HandwrittenNote handwrittenNote);
    HandwrittenNote toHandwrittenNoteEntity(HandwrittenNoteDTO handwrittenNoteDTO);
    TypedNoteDTO toTypedNoteDTO(TypedNote typedNote);
    TypedNote toTypedNoteEntity(TypedNoteDTO typedNoteDTO);
}
