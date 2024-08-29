package com.ceiba.biblioteca.infrastructure.drivenadapter.crud;

import com.ceiba.biblioteca.infrastructure.drivenadapter.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioCrudRepository extends JpaRepository<Usuario, String> {
    Long countPrestamosById(String id);
}
