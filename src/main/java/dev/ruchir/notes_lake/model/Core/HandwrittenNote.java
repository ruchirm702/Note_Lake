package dev.ruchir.notes_lake.model.Core;


import dev.ruchir.notes_lake.model.enums.FileType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "handwritten_notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HandwrittenNote extends BaseNote {

    private String pdfFileUrl;
    private String imageFileUrl;

    @Enumerated(EnumType.STRING)
    private FileType fileType;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "handwritten_note_tags",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;
}
