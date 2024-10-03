package com.usuario.usuario.application.handler.impl;

import com.usuario.usuario.application.dto.request.UsuarioRequestDto;
import com.usuario.usuario.application.dto.response.UsuarioResponseDto;
import com.usuario.usuario.application.handler.IUsuarioHandler;
import com.usuario.usuario.application.mapper.UsuarioRequestMapper;
import com.usuario.usuario.application.mapper.UsuarioResponseMapper;
import com.usuario.usuario.domain.api.IUsuarioServicePort;
import com.usuario.usuario.domain.model.UsuarioModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UsuarioHandler implements IUsuarioHandler {

    private final IUsuarioServicePort objectServicePort;
    private final UsuarioRequestMapper objectRequestMapper;
    private final UsuarioResponseMapper objectResponseMapper;

    @Override
    public void saveObject(UsuarioRequestDto objectRequestDto) {
        UsuarioModel objectModel = objectRequestMapper.toObject(objectRequestDto);
        objectServicePort.saveObject(objectModel);
    }

    @Override
    public List<UsuarioResponseDto> getAllObjects() {
        return objectResponseMapper.toResponseList(objectServicePort.getAllObjects());
    }

    @Override
    public UsuarioResponseDto getByCorreo(String email) {
        return objectResponseMapper.toResponse(objectServicePort.findByCorreo(email));
    }

    @Override
    public UsuarioResponseDto getById(Long id) {
        return objectResponseMapper.toResponse(objectServicePort.findById(id));
    }

}