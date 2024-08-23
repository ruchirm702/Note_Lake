package dev.ruchir.notes_lake.controller;

import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.dto.HandwrittenNoteVersionDTO;
import dev.ruchir.notes_lake.dto.TypedNoteDTO;
import dev.ruchir.notes_lake.dto.TypedNoteVersionDTO;
import dev.ruchir.notes_lake.service.interfaces.VersioningService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes/versions")
public class VersioningController {

    private final VersioningService versioningService;

    public VersioningController(VersioningService versioningService) {
        this.versioningService = versioningService;
    }

    // Endpoint for creating a new handwritten note version
    @PostMapping("/handwritten/{noteId}")
    public ResponseEntity<HandwrittenNoteVersionDTO> createHandwrittenNoteVersion(
            @PathVariable Long noteId,
            @RequestBody HandwrittenNoteDTO updatedNoteDTO) {
        HandwrittenNoteVersionDTO versionDTO = versioningService.createHandwrittenNoteVersion(noteId, updatedNoteDTO);
        return new ResponseEntity<>(versionDTO, HttpStatus.CREATED);
    }

    // Endpoint for creating a new typed note version
    @PostMapping("/typed/{noteId}")
    public ResponseEntity<TypedNoteVersionDTO> createTypedNoteVersion(
            @PathVariable Long noteId,
            @RequestBody TypedNoteDTO updatedNoteDTO) {
        TypedNoteVersionDTO versionDTO = versioningService.createTypedNoteVersion(noteId, updatedNoteDTO);
        return new ResponseEntity<>(versionDTO, HttpStatus.CREATED);
    }

    // Endpoint for retrieving the history of handwritten note versions
    @GetMapping("/handwritten/{noteId}")
    public ResponseEntity<List<HandwrittenNoteVersionDTO>> getHandwrittenNoteHistory(@PathVariable Long noteId) {
        List<HandwrittenNoteVersionDTO> versionHistory = versioningService.getHandwrittenNoteHistory(noteId);
        return new ResponseEntity<>(versionHistory, HttpStatus.OK);
    }

    // Endpoint for retrieving the history of typed note versions
    @GetMapping("/typed/{noteId}")
    public ResponseEntity<List<TypedNoteVersionDTO>> getTypedNoteHistory(@PathVariable Long noteId) {
        List<TypedNoteVersionDTO> versionHistory = versioningService.getTypedNoteHistory(noteId);
        return new ResponseEntity<>(versionHistory, HttpStatus.OK);
    }
}
