package dev.ruchir.notes_lake.controller_advise.custom;

public class InvalidNotificationException extends RuntimeException {
    public InvalidNotificationException(String message) {
        super(message);
    }
}