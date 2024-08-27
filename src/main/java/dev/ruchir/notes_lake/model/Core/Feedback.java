package dev.ruchir.notes_lake.model.Core;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "feedbacks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String comment;

    private int rating; // Optional, if feedback involves ratings

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Who gave the feedback

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "handwritten_note_id")
    private HandwrittenNote handwrittenNote; // If feedback is for a handwritten note

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typed_note_id")
    private TypedNote typedNote; // If feedback is for a typed note

    private LocalDateTime submittedAt = LocalDateTime.now();

    // Optionally, add validation logic to ensure only one note type is set
    @PrePersist
    @PreUpdate
    public void validateNoteAssignment() {
        if ((handwrittenNote != null && typedNote != null) || (handwrittenNote == null && typedNote == null)) {
            throw new IllegalStateException("Feedback must be associated with either a handwritten note or a typed note, not both or neither.");
        }
    }
}
