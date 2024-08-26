package dev.ruchir.notes_lake.controller_advise.custom;

public class NotificationNotFoundException extends RuntimeException {
    public NotificationNotFoundException(String message) {
        super(message);
    }
}
