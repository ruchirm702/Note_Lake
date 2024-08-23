package dev.ruchir.notes_lake.mapper;

import dev.ruchir.notes_lake.dto.SearchResultDTO;
import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.dto.TypedNoteDTO;
import dev.ruchir.notes_lake.dto.TagDTO;
import dev.ruchir.notes_lake.model.Core.HandwrittenNote;
import dev.ruchir.notes_lake.model.Core.TypedNote;
import dev.ruchir.notes_lake.model.Core.Tag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SearchResultMapper {

    SearchResultDTO toSearchResultDTO(List<HandwrittenNoteDTO> handwrittenNotes,
                                      List<TypedNoteDTO> typedNotes,
                                      List<TagDTO> tags);
}
