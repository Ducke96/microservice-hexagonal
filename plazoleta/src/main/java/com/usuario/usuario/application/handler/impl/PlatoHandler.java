package com.usuario.usuario.application.handler.impl;
import com.usuario.usuario.application.dto.request.PlatoRequestDto;
import com.usuario.usuario.application.dto.response.PlatoResponseDto;
import com.usuario.usuario.application.handler.IPlatoHandler;
import com.usuario.usuario.application.mapper.PlatoRequestMapper;
import com.usuario.usuario.application.mapper.PlatoResponseMapper;
import com.usuario.usuario.domain.api.IPlatoServicePort;
import com.usuario.usuario.domain.model.PlatoModel;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PlatoHandler implements IPlatoHandler{
    private final IPlatoServicePort objectServicePort;
    private final PlatoRequestMapper objectRequestMapper;
    private final PlatoResponseMapper objectResponseMapper;

    @Override
    public void saveObject(PlatoRequestDto objectRequestDto) {
        PlatoModel objectModel = objectRequestMapper.toObject(objectRequestDto);
        objectServicePort.saveObject(objectModel);
    }

    @Override
    public List<PlatoResponseDto> getAllObjects() {
        return objectResponseMapper.toResponseList(objectServicePort.getAllObjects());
    }

    @Override
    public PlatoResponseDto updateObject(PlatoRequestDto objectRequestDto) {
        PlatoModel objectModel = objectRequestMapper.toObject(objectRequestDto);
        return objectResponseMapper.toResponse(objectServicePort.updateObject(objectModel));
    }

    @Override
    public PlatoResponseDto findById(Long id) {
        return objectResponseMapper.toResponse(objectServicePort.findById(id));
    }

    @Override
    public  PlatoResponseDto habilitarObject(PlatoRequestDto objectRequestDto) {
        PlatoModel objectModel = objectRequestMapper.toObject(objectRequestDto);
        return objectResponseMapper.toResponse(objectServicePort.habilitarObject(objectModel));
    }
   
    
}
