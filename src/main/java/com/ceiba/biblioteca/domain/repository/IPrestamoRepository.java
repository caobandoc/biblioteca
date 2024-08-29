package com.ceiba.biblioteca.domain.repository;

import com.ceiba.biblioteca.domain.dto.PrestamoDto;

import java.util.Optional;

public interface IPrestamoRepository {

    PrestamoDto save(PrestamoDto prestamoDto);

    Optional<PrestamoDto> findById(Long idPrestamo);


}
