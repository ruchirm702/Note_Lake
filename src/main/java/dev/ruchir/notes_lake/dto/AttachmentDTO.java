package dev.ruchir.notes_lake.dto;

import dev.ruchir.notes_lake.model.enums.FileType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachmentDTO {

    private Long id;
    private String fileName;
    private String fileUrl;
    private FileType fileType;
    private Long noteId; // ID of the note (HandwrittenNote or TypedNote) this attachment belongs to
}
