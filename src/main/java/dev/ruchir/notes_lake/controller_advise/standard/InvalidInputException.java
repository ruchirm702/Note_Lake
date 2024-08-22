package dev.ruchir.notes_lake.controller_advise.standard;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String message) {
        super(message);
    }
}