package dev.ruchir.notes_lake.mapper;

import dev.ruchir.notes_lake.dto.NotificationDTO;
import dev.ruchir.notes_lake.model.Core.HandwrittenNote;
import dev.ruchir.notes_lake.model.Core.Notification;
import dev.ruchir.notes_lake.model.Core.TypedNote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotificationMapper {
    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

    @Mapping(source = "handwrittenNote.id", target = "handwrittenNoteId")
    @Mapping(source = "typedNote.id", target = "typedNoteId")
    NotificationDTO toNotificationDTO(Notification notification);

    @Mapping(source = "handwrittenNoteId", target = "handwrittenNote")
    @Mapping(source = "typedNoteId", target = "typedNote")
    Notification toNotificationEntity(NotificationDTO notificationDTO);

    // Utility methods to map between IDs and note entities (if needed)
    default HandwrittenNote mapHandwrittenNoteIdToEntity(Long handwrittenNoteId) {
        if (handwrittenNoteId == null) {
            return null;
        }
        HandwrittenNote handwrittenNote = new HandwrittenNote();
        handwrittenNote.setId(handwrittenNoteId);
        return handwrittenNote;
    }

    default TypedNote mapTypedNoteIdToEntity(Long typedNoteId) {
        if (typedNoteId == null) {
            return null;
        }
        TypedNote typedNote = new TypedNote();
        typedNote.setId(typedNoteId);
        return typedNote;
    }
}
