package dev.ruchir.notes_lake.controller_advise.custom;

public class VersionNotFoundException extends RuntimeException {

    public VersionNotFoundException(String message) {
        super(message);
    }
}