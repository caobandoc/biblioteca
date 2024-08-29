package com.ceiba.biblioteca.infrastructure.drivenadapter.repository;

import com.ceiba.biblioteca.domain.dto.PrestamoDto;
import com.ceiba.biblioteca.domain.repository.IPrestamoRepository;
import com.ceiba.biblioteca.infrastructure.drivenadapter.crud.IPrestamoCrudRepository;
import com.ceiba.biblioteca.infrastructure.drivenadapter.crud.IUsuarioCrudRepository;
import com.ceiba.biblioteca.infrastructure.drivenadapter.entities.Prestamo;
import com.ceiba.biblioteca.infrastructure.drivenadapter.entities.Usuario;
import com.ceiba.biblioteca.infrastructure.drivenadapter.mapper.PrestamoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PrestamoRepository implements IPrestamoRepository {

    private final IUsuarioCrudRepository usuarioCrudRepository;
    private final IPrestamoCrudRepository prestamoCrudRepository;
    private final PrestamoMapper prestamoMapper;

    @Override
    public PrestamoDto save(PrestamoDto prestamoDto) {
        Prestamo entity = prestamoMapper.toPrestamo(prestamoDto);
        Optional<Usuario> usuario = usuarioCrudRepository.findById(prestamoDto.getUsuario().getId());
        usuario.ifPresent(entity::setUsuario);
        Prestamo entitySaved = prestamoCrudRepository.save(entity);
        return prestamoMapper.toPrestamoDto(entitySaved);
    }

    @Override
    public Optional<PrestamoDto> findById(Long idPrestamo) {
        Optional<Prestamo> entity = prestamoCrudRepository.findById(idPrestamo);
        return entity.map(prestamoMapper::toPrestamoDto);
    }
}
