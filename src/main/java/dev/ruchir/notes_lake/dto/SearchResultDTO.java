package dev.ruchir.notes_lake.dto;

import java.util.List;

public class SearchResultDTO {

    private List<HandwrittenNoteDTO> handwrittenNotes;
    private List<TypedNoteDTO> typedNotes;
    private List<TagDTO> tags;
}
