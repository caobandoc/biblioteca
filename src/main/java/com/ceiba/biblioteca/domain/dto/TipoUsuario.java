package com.ceiba.biblioteca.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoUsuario {
    AFILIADO(10),
    EMPLEADO(8),
    INVITADO(7);

    private final int diasPrestamo;
}
