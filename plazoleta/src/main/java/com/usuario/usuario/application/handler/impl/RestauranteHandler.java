package com.usuario.usuario.application.handler.impl;
import com.usuario.usuario.application.dto.request.RestauranteRequestDto;
import com.usuario.usuario.application.dto.response.RestauranteResponseDto;
import com.usuario.usuario.application.handler.IRestauranteHandler;
import com.usuario.usuario.application.mapper.RestauranteRequestMapper;
import com.usuario.usuario.application.mapper.RestauranteResponseMapper;
import com.usuario.usuario.domain.api.IRestauranteServicePort;
import com.usuario.usuario.domain.model.RestauranteModel;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RestauranteHandler implements IRestauranteHandler{

    private final IRestauranteServicePort objectServicePort;
    private final RestauranteRequestMapper objectRequestMapper;
    private final RestauranteResponseMapper objectResponseMapper;

    @Override
    public void saveObject(RestauranteRequestDto objectRequestDto , String token) {
        RestauranteModel objectModel = objectRequestMapper.toObject(objectRequestDto);
        objectServicePort.saveObject(objectModel , token);
    }

    @Override
    public List<RestauranteResponseDto> getAllObjects() {
        return objectResponseMapper.toResponseList(objectServicePort.getAllObjects());
    }
    

    @Override
    public List<RestauranteResponseDto> getAllObjectsOrderby(int numElements) {
        return objectResponseMapper.toResponseList(objectServicePort.getAllObjectsOrderby(numElements));
    }
}
