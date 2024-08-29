package com.ceiba.biblioteca.domain.repository;

public interface IUsuarioRepository {

    Long countPrestamosById(String identificacionUsuario);
}
