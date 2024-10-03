package com.usuario.usuario.application.handler;

import java.util.List;

import com.usuario.usuario.application.dto.request.RestauranteRequestDto;
import com.usuario.usuario.application.dto.response.RestauranteResponseDto;


public interface IRestauranteHandler {
    void saveObject(RestauranteRequestDto objectRequestDto , String token);
    List<RestauranteResponseDto> getAllObjects();
    List<RestauranteResponseDto> getAllObjectsOrderby(int numElementos);
}
