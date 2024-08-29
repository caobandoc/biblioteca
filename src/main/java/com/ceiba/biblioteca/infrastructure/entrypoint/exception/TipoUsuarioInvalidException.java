package com.ceiba.biblioteca.infrastructure.entrypoint.exception;

public class TipoUsuarioInvalidException extends RuntimeException {
    public TipoUsuarioInvalidException() {
        super("Tipo de usuario no permitido en la biblioteca");
    }
}
