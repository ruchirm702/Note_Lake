package dev.ruchir.notes_lake.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserGroupDTO {

    private Long id;
    private String groupName;
    private Set<UserDTO> members;
    private Set<HandwrittenNoteDTO> sharedHandwrittenNotes;
    private Set<TypedNoteDTO> sharedTypedNotes;
}
