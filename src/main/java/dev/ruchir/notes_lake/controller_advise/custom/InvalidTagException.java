package dev.ruchir.notes_lake.controller_advise.custom;

public class InvalidTagException extends RuntimeException {
    public InvalidTagException(String message) {
        super(message);
    }
}