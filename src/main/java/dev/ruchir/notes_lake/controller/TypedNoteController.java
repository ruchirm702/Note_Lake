package dev.ruchir.notes_lake.controller;


import dev.ruchir.notes_lake.dto.TypedNoteDTO;
import dev.ruchir.notes_lake.service.interfaces.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/typed-notes")
public class TypedNoteController {

    private final NoteService noteService;

    public TypedNoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<TypedNoteDTO> createTypedNote(
            @Valid @RequestBody TypedNoteDTO dto) {
        TypedNoteDTO createdNote = noteService.createTypedNote(dto);
        return new ResponseEntity<>(createdNote, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypedNoteDTO> getTypedNoteById(@PathVariable Long id) {
        TypedNoteDTO note = noteService.getTypedNoteById(id);
        return ResponseEntity.ok(note);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypedNoteById(@PathVariable Long id) {
        noteService.deleteTypedNoteById(id);
        return ResponseEntity.noContent().build();
    }
}