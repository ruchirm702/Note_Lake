package dev.ruchir.notes_lake.controller_advise.standard;

public class UnauthorizedAccessException extends RuntimeException {

    public UnauthorizedAccessException(String message) {
        super(message);
    }
}