package com.ceiba.biblioteca.domain.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class PrestamoDto {
    private Long id;
    private LocalDate fechaDevolucion;
    private UsuarioDto usuario;
    private LibroDto libro;
}
