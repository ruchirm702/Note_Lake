package dev.ruchir.notes_lake.model.Core;

import dev.ruchir.notes_lake.model.enums.AccessLevel;
import dev.ruchir.notes_lake.model.enums.NoteStatus;
import dev.ruchir.notes_lake.model.enums.NoteType;
import dev.ruchir.notes_lake.model.enums.Priority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private NoteType noteType;

    @Enumerated(EnumType.STRING)
    private NoteStatus status = NoteStatus.ACTIVE;

    @Enumerated(EnumType.STRING)
    private AccessLevel accessLevel = AccessLevel.PRIVATE;

    @Enumerated(EnumType.STRING)
    private Priority priority = Priority.MEDIUM;

    private LocalDateTime createdDate = LocalDateTime.now();

    private LocalDateTime updatedDate = LocalDateTime.now();

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }
}