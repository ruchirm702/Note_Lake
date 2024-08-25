package dev.ruchir.notes_lake.controller;

import dev.ruchir.notes_lake.dto.AttachmentDTO;
import dev.ruchir.notes_lake.service.interfaces.AttachmentService;
import dev.ruchir.notes_lake.controller_advise.custom.AttachmentDeletionException;
import dev.ruchir.notes_lake.controller_advise.custom.AttachmentNotFoundException;
import dev.ruchir.notes_lake.controller_advise.custom.AttachmentStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/attachments")
public class AttachmentController {

    private final AttachmentService attachmentService;

    @Autowired
    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttachmentDTO> getAttachmentById(@PathVariable("id") Long id) {
        try {
            AttachmentDTO attachmentDTO = attachmentService.getAttachmentById(id);
            return new ResponseEntity<>(attachmentDTO, HttpStatus.OK);
        } catch (AttachmentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<AttachmentDTO>> getAllAttachments() {
        List<AttachmentDTO> attachments = attachmentService.getAllAttachments();
        return new ResponseEntity<>(attachments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AttachmentDTO> saveAttachment(@Valid @RequestBody AttachmentDTO attachmentDTO) {
        try {
            AttachmentDTO savedAttachment = attachmentService.saveAttachment(attachmentDTO);
            return new ResponseEntity<>(savedAttachment, HttpStatus.CREATED);
        } catch (AttachmentStorageException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttachment(@PathVariable("id") Long id) {
        try {
            attachmentService.deleteAttachment(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (AttachmentDeletionException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
