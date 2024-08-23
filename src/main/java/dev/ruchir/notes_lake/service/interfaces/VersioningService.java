package dev.ruchir.notes_lake.service.interfaces;

import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.dto.HandwrittenNoteVersionDTO;
import dev.ruchir.notes_lake.dto.TypedNoteDTO;
import dev.ruchir.notes_lake.dto.TypedNoteVersionDTO;

import java.util.List;

public interface VersioningService {

    HandwrittenNoteVersionDTO createHandwrittenNoteVersion(Long noteId, HandwrittenNoteDTO updatedNoteDTO);

    TypedNoteVersionDTO createTypedNoteVersion(Long noteId, TypedNoteDTO updatedNoteDTO);

    List<HandwrittenNoteVersionDTO> getHandwrittenNoteHistory(Long noteId);

    List<TypedNoteVersionDTO> getTypedNoteHistory(Long noteId);
}
