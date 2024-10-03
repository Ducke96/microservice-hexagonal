package com.usuario.usuario.domain.spi;

import com.usuario.usuario.domain.model.UsuarioModel;
import java.util.List;

public interface IUsuarioPersistencePort {
    UsuarioModel saveObject(UsuarioModel objectModel);
    UsuarioModel findByCorreo(String email);
    List<UsuarioModel> getAllObjects();
    UsuarioModel findById(Long id);
}