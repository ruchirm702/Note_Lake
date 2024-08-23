package dev.ruchir.notes_lake.controller_advise.custom;

public class VersionConflictException extends RuntimeException {

    public VersionConflictException(String message) {
        super(message);
    }
}