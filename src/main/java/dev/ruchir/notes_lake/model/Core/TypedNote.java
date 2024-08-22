package dev.ruchir.notes_lake.model.Core;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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


}