package dev.ruchir.notes_lake.model.Core;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "typed_note_versions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypedNoteVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long noteId; // ID of the original note

    @Column(nullable = false)
    private int versionNumber; // Version number for tracking sequence

    @Column(nullable = false)
    private LocalDateTime timestamp; // When the version was created

    @Lob
    private String content; // The content of the note

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "typed_note_version_tags",
            joinColumns = @JoinColumn(name = "version_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;

    @Column(nullable = false)
    private LocalDateTime versionDate; // Date of this version
}
