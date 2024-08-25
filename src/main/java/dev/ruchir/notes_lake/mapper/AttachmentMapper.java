package dev.ruchir.notes_lake.mapper;

import dev.ruchir.notes_lake.dto.AttachmentDTO;
import dev.ruchir.notes_lake.model.Core.Attachment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AttachmentMapper {

    AttachmentMapper INSTANCE = Mappers.getMapper(AttachmentMapper.class);

    @Mapping(target = "noteId", expression = "java(getNoteId(attachment))")
    AttachmentDTO toAttachmentDTO(Attachment attachment);

    @Mapping(target = "handwrittenNote", ignore = true)
    @Mapping(target = "typedNote", ignore = true)
    Attachment toAttachmentEntity(AttachmentDTO attachmentDTO);

    List<AttachmentDTO> toAttachmentDTO(List<Attachment> attachments);

    List<Attachment> toAttachmentEntity(List<AttachmentDTO> attachmentDTOs);

    default Long getNoteId(Attachment attachment) {
        if (attachment.getHandwrittenNote() != null) {
            return attachment.getHandwrittenNote().getId();
        } else if (attachment.getTypedNote() != null) {
            return attachment.getTypedNote().getId();
        }
        return null;
    }
}
