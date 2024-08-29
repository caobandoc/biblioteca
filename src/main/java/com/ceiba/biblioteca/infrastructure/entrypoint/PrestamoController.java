package com.ceiba.biblioteca.infrastructure.entrypoint;


import com.ceiba.biblioteca.applications.usecase.IPrestamoUseCase;
import com.ceiba.biblioteca.domain.dto.PrestamoRequestDto;
import com.ceiba.biblioteca.domain.dto.PrestamoResponseDto;
import com.ceiba.biblioteca.domain.dto.TipoUsuario;
import com.ceiba.biblioteca.infrastructure.entrypoint.exception.TipoUsuarioInvalidException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PrestamoController {

    private final IPrestamoUseCase prestamoUseCase;

    @PostMapping("/prestamo")
    public ResponseEntity<PrestamoResponseDto> prestar(@RequestBody PrestamoRequestDto requestPrestamo) {
        if (requestPrestamo.getTipoUsuario() < 1 || requestPrestamo.getTipoUsuario() > TipoUsuario.values().length) {
            throw new TipoUsuarioInvalidException();
        }

        PrestamoResponseDto response = prestamoUseCase.prestar(requestPrestamo);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/prestamo/{id-prestamo}")
    public ResponseEntity<PrestamoResponseDto> consultarPrestamo(@PathVariable("id-prestamo") Long idPrestamo) {
        PrestamoResponseDto responseDto = prestamoUseCase.consultarPrestamo(idPrestamo);
        if (responseDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(responseDto);
    }

}

