package dev.ruchir.notes_lake.mapper;

import dev.ruchir.notes_lake.dto.FeedbackDTO;
import dev.ruchir.notes_lake.model.Core.Feedback;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "handwrittenNote.id", target = "handwrittenNoteId")
    @Mapping(source = "typedNote.id", target = "typedNoteId")
    FeedbackDTO toDto(Feedback feedback);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "handwrittenNoteId", target = "handwrittenNote.id")
    @Mapping(source = "typedNoteId", target = "typedNote.id")
    Feedback toEntity(FeedbackDTO feedbackDTO);
}
