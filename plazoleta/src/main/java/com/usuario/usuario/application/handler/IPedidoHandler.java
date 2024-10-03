package com.usuario.usuario.application.handler;
import java.util.List;

import com.usuario.usuario.application.dto.request.PedidoRequestDto;
import com.usuario.usuario.application.dto.response.PedidoResponseDto;

public interface IPedidoHandler {
    void saveObject(PedidoRequestDto objectRequestDto);
    List<PedidoResponseDto> getAllObjects();
    PedidoResponseDto updateObject(PedidoRequestDto objectRequestDto);
    PedidoResponseDto findById(Long id);
}
