package dev.ruchir.notes_lake.controller;

import dev.ruchir.notes_lake.dto.HandwrittenNoteDTO;
import dev.ruchir.notes_lake.dto.TypedNoteDTO;
import dev.ruchir.notes_lake.service.interfaces.SearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search/handwritten")
    public ResponseEntity<List<HandwrittenNoteDTO>> searchHandwrittenNotes(@RequestParam String query) {
        List<HandwrittenNoteDTO> notes = searchService.searchHandwrittenNotes(query);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/search/typed")
    public ResponseEntity<List<TypedNoteDTO>> searchTypedNotes(@RequestParam String query) {
        List<TypedNoteDTO> notes = searchService.searchTypedNotes(query);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/filter/handwritten")
    public ResponseEntity<List<HandwrittenNoteDTO>> filterHandwrittenNotes(
            @RequestParam String title,
            @RequestParam(required = false) String tag,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        List<HandwrittenNoteDTO> notes = searchService.filterHandwrittenNotes(title, tag, startDate, endDate);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/filter/typed")
    public ResponseEntity<List<TypedNoteDTO>> filterTypedNotes(
            @RequestParam String title,
            @RequestParam(required = false) String tag,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        List<TypedNoteDTO> notes = searchService.filterTypedNotes(title, tag, startDate, endDate);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }
}