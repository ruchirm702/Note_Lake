package dev.ruchir.notes_lake.service.interfaces;

import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.dto.TypedNoteDTO;

import java.util.List;

public interface TaggingService {

    HandwrittenNoteDTO addTagsToHandwrittenNote(Long noteId, List<String> tags);
    TypedNoteDTO addTagsToTypedNote(Long noteId, List<String> tags);

    List<HandwrittenNoteDTO> getHandwrittenNotesByTag(String tag);
    List<TypedNoteDTO> getTypedNotesByTag(String tag);
}
