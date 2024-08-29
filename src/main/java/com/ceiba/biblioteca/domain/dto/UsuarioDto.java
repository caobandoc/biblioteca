package com.ceiba.biblioteca.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UsuarioDto {
    private String id;
    private Integer tipoUsuario;
}
