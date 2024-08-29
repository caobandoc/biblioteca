package com.ceiba.biblioteca.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LibroDto {
    private String id;
    private String isbn;
}
