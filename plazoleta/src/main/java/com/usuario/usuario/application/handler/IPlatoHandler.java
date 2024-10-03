package com.usuario.usuario.application.handler;
import java.util.List;

import com.usuario.usuario.application.dto.request.PlatoRequestDto;
import com.usuario.usuario.application.dto.response.PlatoResponseDto;



public interface IPlatoHandler {
    void saveObject(PlatoRequestDto objectRequestDto);
    List<PlatoResponseDto> getAllObjects();
    PlatoResponseDto updateObject(PlatoRequestDto objectRequestDto);
    PlatoResponseDto findById(Long id);
    PlatoResponseDto habilitarObject(PlatoRequestDto objectModel);

}
