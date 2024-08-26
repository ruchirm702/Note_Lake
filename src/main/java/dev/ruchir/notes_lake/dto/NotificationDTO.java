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
public class NotificationDTO {
    private Long id;
    private String message;
    private Long userId;
    private boolean isRead;
    private LocalDateTime createdAt;
    private Long handwrittenNoteId; // Optional, in case the notification is related to a handwritten note
    private Long typedNoteId; // Optional, in case the notification is related to a typed note
}
