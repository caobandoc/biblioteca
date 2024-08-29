package com.ceiba.biblioteca.infrastructure.entrypoint.exception;

public class ActivePrestamoException extends RuntimeException{
    private static final String MESSAGE = "El usuario con identificación %s ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo";
    public ActivePrestamoException(String id) {
        super(String.format(MESSAGE, id));
    }
}
