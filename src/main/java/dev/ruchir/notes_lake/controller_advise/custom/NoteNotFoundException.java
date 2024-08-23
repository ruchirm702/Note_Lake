package dev.ruchir.notes_lake.controller_advise.custom;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(String message) {
        super(message);
    }
}