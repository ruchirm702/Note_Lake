package dev.ruchir.notes_lake.dto;

import dev.ruchir.notes_lake.model.enums.FileType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HandwrittenNoteDTO extends BaseNoteDTO {

    private String pdfFileUrl;
    private String imageFileUrl;
    private FileType fileType;
}