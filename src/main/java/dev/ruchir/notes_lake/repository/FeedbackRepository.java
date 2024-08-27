package dev.ruchir.notes_lake.repository;

import dev.ruchir.notes_lake.model.Core.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    // Find all feedbacks for a specific user
    List<Feedback> findByUserId(Long userId);

    // Find all feedbacks for a specific handwritten note
    List<Feedback> findByHandwrittenNoteId(Long handwrittenNoteId);

    // Find all feedbacks for a specific typed note
    List<Feedback> findByTypedNoteId(Long typedNoteId);

    // Find feedback by ID, returning Optional
    Optional<Feedback> findById(Long id);

    // Custom query example: find feedbacks by rating
    List<Feedback> findByRating(int rating);
}
