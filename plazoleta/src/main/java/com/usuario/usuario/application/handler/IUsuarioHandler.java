package com.usuario.usuario.application.handler;

import com.usuario.usuario.application.dto.request.UsuarioRequestDto;
import com.usuario.usuario.application.dto.response.UsuarioResponseDto;

import java.util.List;
import java.util.Optional;

public interface IUsuarioHandler {

    void saveObject(UsuarioRequestDto objectRequestDto);

    List<UsuarioResponseDto> getAllObjects();
    Optional<UsuarioResponseDto> findById(Long id , String token);
}