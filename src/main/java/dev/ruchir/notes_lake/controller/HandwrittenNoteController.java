package dev.ruchir.notes_lake.controller;

import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.service.interfaces.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/handwritten-notes")
public class HandwrittenNoteController {

    private final NoteService noteService;


    public HandwrittenNoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<HandwrittenNoteDTO> createHandwrittenNote(
            @Valid @RequestBody HandwrittenNoteDTO dto) {
        HandwrittenNoteDTO createdNote = noteService.createHandwrittenNote(dto);
        return new ResponseEntity<>(createdNote, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HandwrittenNoteDTO> getHandwrittenNoteById(@PathVariable Long id) {
        HandwrittenNoteDTO note = noteService.getHandwrittenNoteById(id);
        return ResponseEntity.ok(note);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHandwrittenNoteById(@PathVariable Long id) {
        noteService.deleteHandwrittenNoteById(id);
        return ResponseEntity.noContent().build();
    }
}
