package dev.ruchir.notes_lake.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NoteSharingDTO {

    private Long id;
    private Long handwrittenNoteId;  // Nullable if not applicable
    private Long typedNoteId;        // Nullable if not applicable
    private Long userId;
    private LocalDateTime sharedAt;
}
