package dev.ruchir.notes_lake.service.interfaces;

import dev.ruchir.notes_lake.controller_advise.custom.AttachmentDeletionException;
import dev.ruchir.notes_lake.controller_advise.custom.AttachmentNotFoundException;
import dev.ruchir.notes_lake.controller_advise.custom.AttachmentStorageException;
import dev.ruchir.notes_lake.dto.AttachmentDTO;


import java.util.List;

public interface AttachmentService {
    AttachmentDTO getAttachmentById(Long id) throws AttachmentNotFoundException;
    List<AttachmentDTO> getAllAttachments();
    AttachmentDTO saveAttachment(AttachmentDTO attachmentDTO) throws AttachmentStorageException;
    void deleteAttachment(Long id) throws AttachmentDeletionException;
}
