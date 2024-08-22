package dev.ruchir.notes_lake.controller_advise.standard;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}