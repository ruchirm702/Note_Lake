package dev.ruchir.notes_lake.service.interfaces;

import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.dto.TypedNoteDTO;

public interface NoteService {

    // Handwritten Note Methods
    HandwrittenNoteDTO createHandwrittenNote(HandwrittenNoteDTO dto);
    HandwrittenNoteDTO getHandwrittenNoteById(Long id);
    void deleteHandwrittenNoteById(Long id);

    // Typed Note Methods
    TypedNoteDTO createTypedNote(TypedNoteDTO dto);
    TypedNoteDTO getTypedNoteById(Long id);
    void deleteTypedNoteById(Long id);
}