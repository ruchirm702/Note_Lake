package dev.ruchir.notes_lake.service.interfaces;

import dev.ruchir.notes_lake.dto.FeedbackDTO;
import java.util.List;

public interface FeedbackService {

    FeedbackDTO createFeedback(FeedbackDTO feedbackDTO);
    FeedbackDTO updateFeedback(Long id, FeedbackDTO feedbackDTO);
    void deleteFeedback(Long id);
    FeedbackDTO getFeedbackById(Long id);
    List<FeedbackDTO> getAllFeedbacks();
    List<FeedbackDTO> getFeedbacksByUserId(Long userId);
    List<FeedbackDTO> getFeedbacksByHandwrittenNoteId(Long handwrittenNoteId);
    List<FeedbackDTO> getFeedbacksByTypedNoteId(Long typedNoteId);
}
