package dev.ruchir.notes_lake.model.Core;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "note_sharing")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteSharing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "handwritten_note_id")
    private HandwrittenNote handwrittenNote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typed_note_id")
    private TypedNote typedNote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDateTime sharedAt;
}
