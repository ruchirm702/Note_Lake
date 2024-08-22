package dev.ruchir.notes_lake.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypedNoteDTO extends BaseNoteDTO {

    private String textContent;
}