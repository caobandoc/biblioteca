package com.ceiba.biblioteca.infrastructure.drivenadapter.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    private String id;
    private Integer tipoUsuario;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST)
    private List<Prestamo> prestamos;
}
