package com.ceiba.biblioteca.infrastructure.drivenadapter.repository;

import com.ceiba.biblioteca.domain.repository.IUsuarioRepository;
import com.ceiba.biblioteca.infrastructure.drivenadapter.crud.IUsuarioCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@RequiredArgsConstructor
@Repository
public class UsuarioRepository implements IUsuarioRepository {

    private final IUsuarioCrudRepository usuarioCrudRepository;

    @Override
    public Long countPrestamosById(String identificacionUsuario) {
        return usuarioCrudRepository.countPrestamosById(identificacionUsuario);
    }
}
