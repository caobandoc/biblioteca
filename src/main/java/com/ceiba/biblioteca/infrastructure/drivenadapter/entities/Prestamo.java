package com.ceiba.biblioteca.infrastructure.drivenadapter.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaDevolucion;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Usuario usuario;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Libro libro;
}
