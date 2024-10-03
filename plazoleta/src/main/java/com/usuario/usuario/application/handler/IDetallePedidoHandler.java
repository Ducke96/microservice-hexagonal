package com.usuario.usuario.application.handler;

import java.util.List;
import com.usuario.usuario.application.dto.request.DetallePedidoResquestDto;
import com.usuario.usuario.application.dto.response.DetallePedidoResponseDto;

public interface IDetallePedidoHandler {
    void saveObject(DetallePedidoResquestDto objectRequestDto);
    List<DetallePedidoResponseDto> getAllObjects();
    DetallePedidoResponseDto updateObject(DetallePedidoResquestDto objectRequestDto);
    DetallePedidoResponseDto findById(Long id); 
}
