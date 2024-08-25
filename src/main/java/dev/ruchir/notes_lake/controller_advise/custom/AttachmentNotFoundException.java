package dev.ruchir.notes_lake.controller_advise.custom;

public class AttachmentNotFoundException extends RuntimeException {
    public AttachmentNotFoundException(String message) {
        super(message);
    }
}
