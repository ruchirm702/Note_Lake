package dev.ruchir.notes_lake.service.impl;

import dev.ruchir.notes_lake.dto.AttachmentDTO;
import dev.ruchir.notes_lake.mapper.AttachmentMapper;
import dev.ruchir.notes_lake.model.Core.Attachment;
import dev.ruchir.notes_lake.repository.AttachmentRepository;
import dev.ruchir.notes_lake.controller_advise.custom.AttachmentDeletionException;
import dev.ruchir.notes_lake.controller_advise.custom.AttachmentNotFoundException;
import dev.ruchir.notes_lake.controller_advise.custom.AttachmentStorageException;
import dev.ruchir.notes_lake.service.interfaces.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final AttachmentMapper attachmentMapper = AttachmentMapper.INSTANCE;

    @Autowired
    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public AttachmentDTO getAttachmentById(Long id) throws AttachmentNotFoundException {
        Optional<Attachment> attachment = attachmentRepository.findById(id);
        if (attachment.isPresent()) {
            return attachmentMapper.toAttachmentDTO(attachment.get());
        } else {
            throw new AttachmentNotFoundException("Attachment not found with id: " + id);
        }
    }

    @Override
    public List<AttachmentDTO> getAllAttachments() {
        List<Attachment> attachments = attachmentRepository.findAll();
        return attachmentMapper.toAttachmentDTO(attachments);
    }

    @Override
    public AttachmentDTO saveAttachment(AttachmentDTO attachmentDTO) throws AttachmentStorageException {
        try {
            Attachment attachment = attachmentMapper.toAttachmentEntity(attachmentDTO);
            Attachment savedAttachment = attachmentRepository.save(attachment);
            return attachmentMapper.toAttachmentDTO(savedAttachment);
        } catch (Exception e) {
            throw new AttachmentStorageException("Failed to store the attachment", e);
        }
    }

    @Override
    public void deleteAttachment(Long id) throws AttachmentDeletionException {
        try {
            if (attachmentRepository.existsById(id)) {
                attachmentRepository.deleteById(id);
            } else {
                throw new AttachmentNotFoundException("Attachment not found with id: " + id);
            }
        } catch (Exception e) {
            throw new AttachmentDeletionException("Failed to delete the attachment with id: " + id);
        }
    }
}
