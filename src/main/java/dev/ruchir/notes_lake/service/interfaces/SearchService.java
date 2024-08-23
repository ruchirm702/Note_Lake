package dev.ruchir.notes_lake.service.interfaces;

import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.dto.TypedNoteDTO;

import java.time.LocalDate;
import java.util.List;

public interface SearchService {

    List<HandwrittenNoteDTO> searchHandwrittenNotes(String query);
    List<TypedNoteDTO> searchTypedNotes(String query);
    List<HandwrittenNoteDTO> filterHandwrittenNotes(String title, String tag, LocalDate startDate, LocalDate endDate);
    List<TypedNoteDTO> filterTypedNotes(String title, String tag, LocalDate startDate, LocalDate endDate);
}