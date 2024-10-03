package com.usuario.usuario.domain.spi;

import com.usuario.usuario.domain.model.UsuarioModel;
import com.usuario.usuario.infrastructure.out.jpa.entity.Usuario;

import java.util.List;

import java.util.Optional;

public interface IUsuarioPersistencePort {
    UsuarioModel saveObject(UsuarioModel objectModel);
    List<UsuarioModel> getAllObjects();
    Optional<Usuario> findByCorreo(String email);
    Optional<UsuarioModel> findById(Long id ,String token);

}