package dev.ruchir.notes_lake.controller_advise.custom;

public class FeedbackServiceException extends RuntimeException {
    public FeedbackServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}