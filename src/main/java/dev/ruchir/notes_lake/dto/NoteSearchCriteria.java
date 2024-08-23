package dev.ruchir.notes_lake.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class NoteSearchCriteria {

    private String title;
    private String tag;
    private LocalDate startDate;
    private LocalDate endDate;
}