package dev.ruchir.notes_lake.dto;

import dev.ruchir.notes_lake.model.enums.AccessLevel;
import dev.ruchir.notes_lake.model.enums.NoteStatus;
import dev.ruchir.notes_lake.model.enums.NoteType;
import dev.ruchir.notes_lake.model.enums.Priority;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseNoteDTO {

    private Long id;
    private String title;
    private NoteType noteType;
    private NoteStatus status;
    private AccessLevel accessLevel;
    private Priority priority;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}