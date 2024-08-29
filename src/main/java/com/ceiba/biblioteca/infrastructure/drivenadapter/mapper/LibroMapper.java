package com.ceiba.biblioteca.infrastructure.drivenadapter.mapper;

import com.ceiba.biblioteca.domain.dto.LibroDto;
import com.ceiba.biblioteca.infrastructure.drivenadapter.entities.Libro;
import org.springframework.stereotype.Component;

@Component
public class LibroMapper {
    public LibroDto toLibroDto(Libro libro) {
        return LibroDto.builder()
                .id(libro.getId())
                .isbn(libro.getIsbn())
                .build();
    }

    public Libro toLibro(LibroDto libro) {
        Libro libroEntity = new Libro();
        libroEntity.setId(libro.getId());
        libroEntity.setIsbn(libro.getIsbn());
        return libroEntity;
    }
}
