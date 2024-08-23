package dev.ruchir.notes_lake.dto;

import dev.ruchir.notes_lake.model.enums.FileType;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class HandwrittenNoteDTO extends BaseNoteDTO {

    private String pdfFileUrl;
    private String imageFileUrl;
    private FileType fileType;
    private Set<TagDTO> tags;
}