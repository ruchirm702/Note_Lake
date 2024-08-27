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
    private int rating; // Optional
    private Long userId; // ID of the user who gave feedback
    private Long noteId; // ID of the note (either handwritten or typed) associated with the feedback
    private LocalDateTime submittedAt;
}
