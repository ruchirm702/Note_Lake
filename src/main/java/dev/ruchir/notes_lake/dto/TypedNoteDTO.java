package dev.ruchir.notes_lake.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class TypedNoteDTO extends BaseNoteDTO {

    private String textContent;
    private Set<TagDTO> tags;
    private Set<String> tagNames;
}
