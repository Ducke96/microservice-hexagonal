package com.usuario.usuario.domain.api;
import com.usuario.usuario.domain.model.UsuarioModel;

import java.util.List;
import java.util.Optional;


public interface IUsuarioServicePort {

    void saveObject(UsuarioModel objectModel);
    List<UsuarioModel> getAllObjects();
    Optional<UsuarioModel> findById(Long id ,String token);
}