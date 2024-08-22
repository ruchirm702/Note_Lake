package dev.ruchir.notes_lake.controller_advise.custom;

public class NoteAlreadyExistsException extends RuntimeException {
    public NoteAlreadyExistsException(String message) {
        super(message);
    }
}