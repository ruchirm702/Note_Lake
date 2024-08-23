package dev.ruchir.notes_lake.controller;

import dev.ruchir.notes_lake.controller_advise.custom.NoteNotFoundException;
import dev.ruchir.notes_lake.controller_advise.standard.ResourceNotFoundException;
import dev.ruchir.notes_lake.controller_advise.standard.UnauthorizedAccessException;
import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.dto.TypedNoteDTO;
import dev.ruchir.notes_lake.service.interfaces.SharingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sharing")
public class SharingController {

    private final SharingService sharingService;

    public SharingController(SharingService sharingService) {
        this.sharingService = sharingService;
    }

    @PostMapping("/handwritten/{noteId}/user/{userId}")
    public ResponseEntity<Void> shareHandwrittenNoteWithUser(@PathVariable Long noteId, @PathVariable Long userId) {
        try {
            sharingService.shareHandwrittenNoteWithUser(noteId, userId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (UnauthorizedAccessException | NoteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/typed/{noteId}/user/{userId}")
    public ResponseEntity<Void> shareTypedNoteWithUser(@PathVariable Long noteId, @PathVariable Long userId) {
        try {
            sharingService.shareTypedNoteWithUser(noteId, userId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (UnauthorizedAccessException | NoteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/handwritten/{userId}")
    public ResponseEntity<List<HandwrittenNoteDTO>> getSharedHandwrittenNotes(@PathVariable Long userId) {
        try {
            List<HandwrittenNoteDTO> notes = sharingService.getSharedHandwrittenNotes(userId);
            return ResponseEntity.ok(notes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/typed/{userId}")
    public ResponseEntity<List<TypedNoteDTO>> getSharedTypedNotes(@PathVariable Long userId) {
        try {
            List<TypedNoteDTO> notes = sharingService.getSharedTypedNotes(userId);
            return ResponseEntity.ok(notes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
