package dev.ruchir.notes_lake.controller_advise.custom;

public class TagNotFoundException extends RuntimeException {
    public TagNotFoundException(String message) {
        super(message);
    }
}