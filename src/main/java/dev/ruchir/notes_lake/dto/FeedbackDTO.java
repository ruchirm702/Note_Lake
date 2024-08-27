package dev.ruchir.notes_lake.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDTO {

    private Long id;
    private String comment;
    private int rating;
    private Long userId;
    private Long handwrittenNoteId; // ID for handwritten note (if applicable)
    private Long typedNoteId; // ID for typed note (if applicable)
    private LocalDateTime submittedAt;
}
