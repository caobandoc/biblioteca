package com.ceiba.biblioteca.domain.service;

import com.ceiba.biblioteca.applications.usecase.IPrestamoUseCase;
import com.ceiba.biblioteca.domain.dto.LibroDto;
import com.ceiba.biblioteca.domain.dto.PrestamoDto;
import com.ceiba.biblioteca.domain.dto.PrestamoRequestDto;
import com.ceiba.biblioteca.domain.dto.PrestamoResponseDto;
import com.ceiba.biblioteca.domain.dto.TipoUsuario;
import com.ceiba.biblioteca.domain.dto.UsuarioDto;
import com.ceiba.biblioteca.domain.repository.IPrestamoRepository;
import com.ceiba.biblioteca.domain.repository.IUsuarioRepository;
import com.ceiba.biblioteca.infrastructure.entrypoint.exception.ActivePrestamoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PrestamoService implements IPrestamoUseCase {

    private final IUsuarioRepository usuarioRepository;
    private final IPrestamoRepository prestamoRepository;

    @Override
    public PrestamoResponseDto prestar(PrestamoRequestDto requestPrestamo) {
        if (requestPrestamo.getTipoUsuarioEnum() == TipoUsuario.INVITADO &&
                usuarioRepository.countPrestamosById(requestPrestamo.getIdentificacionUsuario()) > 0) {
            throw new ActivePrestamoException(requestPrestamo.getIdentificacionUsuario());
        }

        PrestamoDto prestamoDto = createPrestamoDto(requestPrestamo);
        PrestamoDto prestamoSave = prestamoRepository.save(prestamoDto);
        return PrestamoResponseDto.builder()
                .id(prestamoSave.getId())
                .fechaMaximaDevolucion(prestamoSave.getFechaDevolucion())
                .build();
    }

    @Override
    public PrestamoResponseDto consultarPrestamo(Long idPrestamo) {
        Optional<PrestamoDto> prestamoSearch = prestamoRepository.findById(idPrestamo);
        return prestamoSearch.map(prestamoDto -> PrestamoResponseDto.builder()
                .id(prestamoDto.getId())
                .isbn(prestamoDto.getLibro().getIsbn())
                .identificacionUsuario(prestamoDto.getUsuario().getId())
                .tipoUsuario(prestamoDto.getUsuario().getTipoUsuario())
                .fechaMaximaDevolucion(prestamoDto.getFechaDevolucion())
                .build()).orElse(null);
    }

    private PrestamoDto createPrestamoDto(PrestamoRequestDto requestPrestamo) {
        LibroDto libro = LibroDto.builder().isbn(requestPrestamo.getIsbn()).build();
        UsuarioDto usuarioDto = UsuarioDto.builder()
                .id(requestPrestamo.getIdentificacionUsuario())
                .tipoUsuario(requestPrestamo.getTipoUsuario())
                .build();
        return PrestamoDto.builder()
                .fechaDevolucion(calcularFechaEntrega(requestPrestamo.getTipoUsuarioEnum()))
                .libro(libro)
                .usuario(usuarioDto)
                .build();
    }

    private LocalDate calcularFechaEntrega(TipoUsuario tipoUsuario) {
        int diasParaAgregar = tipoUsuario.getDiasPrestamo();

        LocalDate fechaEntrega = LocalDate.now();
        int diasAgregados = 0;
        while (diasAgregados < diasParaAgregar) {
            fechaEntrega = fechaEntrega.plusDays(1);
            if (!(fechaEntrega.getDayOfWeek() == DayOfWeek.SATURDAY || fechaEntrega.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                diasAgregados++;
            }
        }
        return fechaEntrega;
    }
}
