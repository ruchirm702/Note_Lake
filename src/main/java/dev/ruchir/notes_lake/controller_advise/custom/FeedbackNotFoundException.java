package dev.ruchir.notes_lake.controller_advise.custom;

public class FeedbackNotFoundException extends RuntimeException {
    public FeedbackNotFoundException(String message) {
        super(message);
    }
}