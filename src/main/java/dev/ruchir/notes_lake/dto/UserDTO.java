package dev.ruchir.notes_lake.dto;

import dev.ruchir.notes_lake.model.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String username;
    private Set<UserRole> roles;
}