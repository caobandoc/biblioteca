package com.ceiba.biblioteca.applications.usecase;

import com.ceiba.biblioteca.domain.dto.PrestamoRequestDto;
import com.ceiba.biblioteca.domain.dto.PrestamoResponseDto;

public interface IPrestamoUseCase {

    PrestamoResponseDto prestar(PrestamoRequestDto requestPrestamo);

    PrestamoResponseDto consultarPrestamo(Long idPrestamo);
}
