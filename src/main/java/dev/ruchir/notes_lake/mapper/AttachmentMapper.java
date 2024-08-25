package dev.ruchir.notes_lake.mapper;

import dev.ruchir.notes_lake.dto.AttachmentDTO;
import dev.ruchir.notes_lake.model.Core.Attachment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AttachmentMapper {

    AttachmentMapper INSTANCE = Mappers.getMapper(AttachmentMapper.class);

    @Mapping(target = "noteId", expression = "java(getNoteId(attachment))")
    AttachmentDTO toAttachmentDTO(Attachment attachment);

    @Mapping(target = "handwrittenNote", ignore = true)
    @Mapping(target = "typedNote", ignore = true)
    Attachment toAttachmentEntity(AttachmentDTO attachmentDTO);

    default Long getNoteId(Attachment attachment) {
        if (attachment.getHandwrittenNote() != null) {
            return attachment.getHandwrittenNote().getId();
        } else if (attachment.getTypedNote() != null) {
            return attachment.getTypedNote().getId();
        }
        return null;
    }
}
