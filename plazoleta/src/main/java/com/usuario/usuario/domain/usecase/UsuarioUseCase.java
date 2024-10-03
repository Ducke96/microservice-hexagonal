package com.usuario.usuario.domain.usecase;

import com.usuario.usuario.domain.api.IUsuarioServicePort;
import com.usuario.usuario.domain.model.UsuarioModel;
import com.usuario.usuario.domain.spi.IUsuarioPersistencePort;

import java.util.Optional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioUseCase implements IUsuarioServicePort {

    private final IUsuarioPersistencePort objectPersistencePort;

    public UsuarioUseCase(IUsuarioPersistencePort objectPersistencePort) {
        this.objectPersistencePort = objectPersistencePort;
    }

    @Override
    public void saveObject(UsuarioModel objectModel) {
        objectPersistencePort.saveObject(objectModel);
    }

    @Override
    public List<UsuarioModel> getAllObjects() {
        return objectPersistencePort.getAllObjects();
    }

    @Override
    public  Optional<UsuarioModel> findById(Long id , String token) {
        return objectPersistencePort.findById(id,token);
    }


   
}