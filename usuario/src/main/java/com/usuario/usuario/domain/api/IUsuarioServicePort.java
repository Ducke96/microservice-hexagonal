package com.usuario.usuario.domain.api;
import com.usuario.usuario.domain.model.UsuarioModel;

import java.util.List;

public interface IUsuarioServicePort {

    void saveObject(UsuarioModel objectModel);
    List<UsuarioModel> getAllObjects();
    UsuarioModel findByCorreo(String email);
    UsuarioModel findById(Long id);
}