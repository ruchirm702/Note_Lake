package dev.ruchir.notes_lake.controller_advise.custom;

public class InvalidNoteException extends RuntimeException {
    public InvalidNoteException(String message) {
        super(message);
    }
}
