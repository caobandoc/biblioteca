package com.ceiba.biblioteca.infrastructure.entrypoint;

import com.ceiba.biblioteca.infrastructure.entrypoint.exception.ActivePrestamoException;
import com.ceiba.biblioteca.infrastructure.entrypoint.exception.TipoUsuarioInvalidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ActivePrestamoException.class)
    public ResponseEntity<Object> handleActivePrestamoException(ActivePrestamoException ex) {
        Map<String, String> body = createResponse(ex.getMessage());
        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(TipoUsuarioInvalidException.class)
    public ResponseEntity<Object> handleTipoUsuarioInvalidException(TipoUsuarioInvalidException ex) {
        Map<String, String> body = createResponse(ex.getMessage());
        return ResponseEntity.badRequest().body(body);
    }

    private static Map<String, String> createResponse(String ex) {
        Map<String, String> body = new HashMap<>();
        body.put("mensaje", ex);
        return body;
    }
}
