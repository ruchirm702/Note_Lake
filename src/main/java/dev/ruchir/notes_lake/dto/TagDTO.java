package dev.ruchir.notes_lake.dto;

import dev.ruchir.notes_lake.model.enums.TagType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagDTO {

    private Long id;
    private String name;
    private TagType tagType;
}
