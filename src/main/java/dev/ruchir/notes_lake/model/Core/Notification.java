package dev.ruchir.notes_lake.model.Core;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @Column(nullable = false)
    private Long userId;

    private boolean isRead = false; // Track if the notification has been read

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // Relationship to HandwrittenNote (optional)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "handwritten_note_id")
    private HandwrittenNote handwrittenNote;

    // Relationship to TypedNote (optional)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typed_note_id")
    private TypedNote typedNote;
}
