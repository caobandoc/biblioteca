package com.ceiba.biblioteca.infrastructure.drivenadapter.mapper;

import com.ceiba.biblioteca.domain.dto.UsuarioDto;
import com.ceiba.biblioteca.infrastructure.drivenadapter.entities.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioDto toUsuarioDto(Usuario usuario) {
        return UsuarioDto.builder()
                .id(usuario.getId())
                .tipoUsuario(usuario.getTipoUsuario())
                .build();
    }

    public Usuario toUsuario(UsuarioDto usuario) {
        Usuario usuarioEntity = new Usuario();
        usuarioEntity.setId(usuario.getId());
        usuarioEntity.setTipoUsuario(usuario.getTipoUsuario());
        return usuarioEntity;
    }
}
