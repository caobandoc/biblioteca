package com.ceiba.biblioteca.domain.dto;

import lombok.Data;

@Data
public class PrestamoRequestDto {
    private String isbn;
    private String identificacionUsuario;
    private int tipoUsuario;

    public TipoUsuario getTipoUsuarioEnum() {
        return TipoUsuario.values()[this.tipoUsuario-1];
    }
}
