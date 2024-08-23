package dev.ruchir.notes_lake.model.Core;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "typed_notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypedNote extends BaseNote {

    @Lob
    private String textContent;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "typed_note_tags",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;
}
