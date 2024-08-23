package dev.ruchir.notes_lake.mapper;

import dev.ruchir.notes_lake.dto.SearchResultDTO;
import dev.ruchir.notes_lake.model.Core.HandwrittenNote;
import dev.ruchir.notes_lake.model.Core.TypedNote;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SearchResultMapper {

    // Assuming SearchResultDTO contains lists or aggregates of notes and tags
    SearchResultDTO toSearchResultDTO(List<HandwrittenNote> handwrittenNotes, List<TypedNote> typedNotes);
}