package com.usuario.usuario.domain.usecase;

import com.usuario.usuario.domain.api.IUsuarioServicePort;
import com.usuario.usuario.domain.model.UsuarioModel;
import com.usuario.usuario.domain.spi.IUsuarioPersistencePort;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioUseCase implements IUsuarioServicePort {

    private final IUsuarioPersistencePort objectPersistencePort;
    private final PasswordEncoder passwordEncoder;

    public UsuarioUseCase(IUsuarioPersistencePort objectPersistencePort ,PasswordEncoder passwordEncoder) {
        this.objectPersistencePort = objectPersistencePort;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveObject(UsuarioModel objectModel) {

        objectModel.setClave(passwordEncoder.encode(objectModel.getClave()));
        objectPersistencePort.saveObject(objectModel);
    }

    @Override
    public List<UsuarioModel> getAllObjects() {
        return objectPersistencePort.getAllObjects();
    }

    @Override
    public UsuarioModel findByCorreo(String email){
        return objectPersistencePort.findByCorreo(email);
    }

    @Override
    public UsuarioModel findById(Long id){
        return objectPersistencePort.findById(id);
    }

}