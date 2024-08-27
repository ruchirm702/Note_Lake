package dev.ruchir.notes_lake.controller_advise.custom;

public class InvalidFeedbackException extends RuntimeException {
    public InvalidFeedbackException(String message) {
        super(message);
    }
}