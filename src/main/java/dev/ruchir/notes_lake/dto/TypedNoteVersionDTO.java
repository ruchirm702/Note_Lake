package dev.ruchir.notes_lake.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class TypedNoteVersionDTO {

    private Long id;
    private Long noteId; // ID of the original note
    private int versionNumber; // Version number for tracking sequence
    private LocalDateTime timestamp; // When the version was created
    private String content; // The content of the note
    private Set<TagDTO> tags; // Tags associated with this version
    private LocalDateTime versionDate; // Date of this version
}
