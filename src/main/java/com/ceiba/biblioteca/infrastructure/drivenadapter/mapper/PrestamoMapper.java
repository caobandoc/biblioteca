package com.ceiba.biblioteca.infrastructure.drivenadapter.mapper;

import com.ceiba.biblioteca.domain.dto.PrestamoDto;
import com.ceiba.biblioteca.infrastructure.drivenadapter.entities.Prestamo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PrestamoMapper {
    private final UsuarioMapper usuarioMapper;
    private final LibroMapper libroMapper;
    public PrestamoDto toPrestamoDto(Prestamo prestamo) {
        return PrestamoDto.builder()
                .id(prestamo.getId())
                .fechaDevolucion(prestamo.getFechaDevolucion())
                .libro(libroMapper.toLibroDto(prestamo.getLibro()))
                .usuario(usuarioMapper.toUsuarioDto(prestamo.getUsuario()))
                .build();
    }


    public Prestamo toPrestamo(PrestamoDto prestamoDto) {
        Prestamo prestamo = new Prestamo();
        prestamo.setId(prestamoDto.getId());
        prestamo.setFechaDevolucion(prestamoDto.getFechaDevolucion());
        prestamo.setLibro(libroMapper.toLibro(prestamoDto.getLibro()));
        prestamo.setUsuario(usuarioMapper.toUsuario(prestamoDto.getUsuario()));
        return prestamo;
    }
}
