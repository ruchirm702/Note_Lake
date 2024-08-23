package dev.ruchir.notes_lake.controller;

import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.dto.TypedNoteDTO;
import dev.ruchir.notes_lake.service.interfaces.TaggingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TaggingController {

    private final TaggingService taggingService;

    // Endpoint to add tags to a handwritten note
    @PostMapping("/handwritten/{noteId}")
    public ResponseEntity<HandwrittenNoteDTO> addTagsToHandwrittenNote(
            @PathVariable Long noteId,
            @RequestBody List<String> tags) {
        HandwrittenNoteDTO updatedNote = taggingService.addTagsToHandwrittenNote(noteId, tags);
        return ResponseEntity.ok(updatedNote);
    }

    // Endpoint to add tags to a typed note
    @PostMapping("/typed/{noteId}")
    public ResponseEntity<TypedNoteDTO> addTagsToTypedNote(
            @PathVariable Long noteId,
            @RequestBody List<String> tags) {
        TypedNoteDTO updatedNote = taggingService.addTagsToTypedNote(noteId, tags);
        return ResponseEntity.ok(updatedNote);
    }

    // Endpoint to get handwritten notes by tag
    @GetMapping("/handwritten")
    public ResponseEntity<List<HandwrittenNoteDTO>> getHandwrittenNotesByTag(@RequestParam String tag) {
        List<HandwrittenNoteDTO> notes = taggingService.getHandwrittenNotesByTag(tag);
        return ResponseEntity.ok(notes);
    }

    // Endpoint to get typed notes by tag
    @GetMapping("/typed")
    public ResponseEntity<List<TypedNoteDTO>> getTypedNotesByTag(@RequestParam String tag) {
        List<TypedNoteDTO> notes = taggingService.getTypedNotesByTag(tag);
        return ResponseEntity.ok(notes);
    }
}
