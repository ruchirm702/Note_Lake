package dev.ruchir.notes_lake.model.Core;

import dev.ruchir.notes_lake.model.enums.FileType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "attachments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String fileUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FileType fileType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "handwritten_note_id")
    private HandwrittenNote handwrittenNote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typed_note_id")
    private TypedNote typedNote;

    private LocalDateTime createdDate = LocalDateTime.now();

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }
}
