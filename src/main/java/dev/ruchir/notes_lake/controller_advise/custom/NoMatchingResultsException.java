package dev.ruchir.notes_lake.controller_advise.custom;

public class NoMatchingResultsException extends RuntimeException {
    public NoMatchingResultsException(String message) {
        super(message);
    }
}