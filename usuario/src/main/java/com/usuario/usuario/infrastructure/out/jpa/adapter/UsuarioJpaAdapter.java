package com.usuario.usuario.infrastructure.out.jpa.adapter;

import com.usuario.usuario.domain.model.UsuarioModel;
import com.usuario.usuario.domain.spi.IUsuarioPersistencePort;
import com.usuario.usuario.infrastructure.exception.NoDataFoundException;
import com.usuario.usuario.infrastructure.out.jpa.entity.Usuario;
import com.usuario.usuario.infrastructure.out.jpa.mapper.IUsuarioEntityMapper;
import com.usuario.usuario.infrastructure.out.jpa.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class UsuarioJpaAdapter implements IUsuarioPersistencePort {

    private final IUsuarioRepository objectRepository;
    private final IUsuarioEntityMapper objectEntityMapper;


    @Override
    public UsuarioModel saveObject(UsuarioModel objectModel) {
        Usuario objectEntity = objectRepository.save(objectEntityMapper.toEntity(objectModel));
        return objectEntityMapper.toObjectModel(objectEntity);
    }

    @Override
    public List<UsuarioModel> getAllObjects() {
        List<Usuario> entityList = objectRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return objectEntityMapper.toObjectModelList(entityList);
    }

    @Override
    public UsuarioModel findByCorreo(String email) {
        Optional<Usuario> entity = objectRepository.findByCorreo(email);
        if (entity.isEmpty()) {
            throw new NoDataFoundException();
        }
        return objectEntityMapper.toObjectModel(entity.get());
    }


    @Override
    public UsuarioModel findById(Long id) {

        Optional<Usuario> entity = objectRepository.findById(id.intValue());
        if (entity.isEmpty()) {
            throw new NoDataFoundException();
        }
        return objectEntityMapper.toObjectModel(entity.get());
    }

}