package com.ceiba.biblioteca.infrastructure.drivenadapter.crud;

import com.ceiba.biblioteca.infrastructure.drivenadapter.entities.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPrestamoCrudRepository extends JpaRepository<Prestamo, Long> {
}
