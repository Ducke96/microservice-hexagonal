package com.usuario.usuario.application.handler;

import com.usuario.usuario.application.dto.request.UsuarioRequestDto;
import com.usuario.usuario.application.dto.response.UsuarioResponseDto;

import java.util.List;

public interface IUsuarioHandler {

    void saveObject(UsuarioRequestDto objectRequestDto);

    List<UsuarioResponseDto> getAllObjects();
    UsuarioResponseDto getByCorreo(String email);
    UsuarioResponseDto getById(Long id);
}