package dev.ruchir.notes_lake.controller_advise.custom;

public class InvalidAttachmentException extends RuntimeException {
    public InvalidAttachmentException(String message) {
        super(message);
    }
}
