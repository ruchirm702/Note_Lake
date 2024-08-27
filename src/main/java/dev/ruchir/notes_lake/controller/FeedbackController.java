package dev.ruchir.notes_lake.controller;

import dev.ruchir.notes_lake.dto.FeedbackDTO;
import dev.ruchir.notes_lake.controller_advise.custom.FeedbackNotFoundException;
import dev.ruchir.notes_lake.controller_advise.custom.InvalidFeedbackException;
import dev.ruchir.notes_lake.service.interfaces.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<FeedbackDTO> createFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        try {
            FeedbackDTO createdFeedback = feedbackService.createFeedback(feedbackDTO);
            return new ResponseEntity<>(createdFeedback, HttpStatus.CREATED);
        } catch (InvalidFeedbackException ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedbackDTO> updateFeedback(@PathVariable Long id, @RequestBody FeedbackDTO feedbackDTO) {
        try {
            FeedbackDTO updatedFeedback = feedbackService.updateFeedback(id, feedbackDTO);
            return new ResponseEntity<>(updatedFeedback, HttpStatus.OK);
        } catch (FeedbackNotFoundException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (InvalidFeedbackException ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        try {
            feedbackService.deleteFeedback(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (FeedbackNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackDTO> getFeedbackById(@PathVariable Long id) {
        try {
            FeedbackDTO feedbackDTO = feedbackService.getFeedbackById(id);
            return new ResponseEntity<>(feedbackDTO, HttpStatus.OK);
        } catch (FeedbackNotFoundException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<FeedbackDTO>> getAllFeedbacks() {
        List<FeedbackDTO> feedbacks = feedbackService.getAllFeedbacks();
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FeedbackDTO>> getFeedbacksByUserId(@PathVariable Long userId) {
        List<FeedbackDTO> feedbacks = feedbackService.getFeedbacksByUserId(userId);
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @GetMapping("/handwritten-note/{handwrittenNoteId}")
    public ResponseEntity<List<FeedbackDTO>> getFeedbacksByHandwrittenNoteId(@PathVariable Long handwrittenNoteId) {
        List<FeedbackDTO> feedbacks = feedbackService.getFeedbacksByHandwrittenNoteId(handwrittenNoteId);
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @GetMapping("/typed-note/{typedNoteId}")
    public ResponseEntity<List<FeedbackDTO>> getFeedbacksByTypedNoteId(@PathVariable Long typedNoteId) {
        List<FeedbackDTO> feedbacks = feedbackService.getFeedbacksByTypedNoteId(typedNoteId);
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }
}
