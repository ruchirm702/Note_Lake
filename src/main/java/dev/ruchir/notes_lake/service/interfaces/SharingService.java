package dev.ruchir.notes_lake.service.interfaces;

import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.dto.TypedNoteDTO;
import dev.ruchir.notes_lake.controller_advise.custom.NoteNotFoundException;
import dev.ruchir.notes_lake.controller_advise.standard.ResourceNotFoundException;
import dev.ruchir.notes_lake.controller_advise.standard.UnauthorizedAccessException;

import java.util.List;

public interface SharingService {

    void shareHandwrittenNoteWithUser(Long noteId, Long userId) throws UnauthorizedAccessException, NoteNotFoundException;
    void shareTypedNoteWithUser(Long noteId, Long userId) throws UnauthorizedAccessException, NoteNotFoundException;
    List<HandwrittenNoteDTO> getSharedHandwrittenNotes(Long userId) throws ResourceNotFoundException;
    List<TypedNoteDTO> getSharedTypedNotes(Long userId) throws ResourceNotFoundException;
}
