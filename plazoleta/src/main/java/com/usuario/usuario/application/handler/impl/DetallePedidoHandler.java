package com.usuario.usuario.application.handler.impl;

import java.util.List;

import com.usuario.usuario.application.dto.request.DetallePedidoResquestDto;
import com.usuario.usuario.application.dto.response.DetallePedidoResponseDto;
import com.usuario.usuario.application.handler.IDetallePedidoHandler;
import com.usuario.usuario.application.mapper.DetallePedidoRequestMapper;
import com.usuario.usuario.application.mapper.DetallePedidoResponseMapper;
import com.usuario.usuario.domain.api.IDetallePedidoServicePort;
import com.usuario.usuario.domain.model.DetallePedidoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
@Transactional
public class DetallePedidoHandler implements  IDetallePedidoHandler{
    private final IDetallePedidoServicePort objectServicePort;
    private final DetallePedidoRequestMapper objectRequestMapper;
    private final DetallePedidoResponseMapper objectResponseMapper;

    @Override
    public void saveObject(DetallePedidoResquestDto objectRequestDto) {
        DetallePedidoModel objectModel = objectRequestMapper.toObject(objectRequestDto);
        objectServicePort.saveObject(objectModel);
    }

    @Override
    public List<DetallePedidoResponseDto> getAllObjects() {
        return objectResponseMapper.toResponseList(objectServicePort.getAllObjects());
    }

    @Override
    public DetallePedidoResponseDto updateObject(DetallePedidoResquestDto objectRequestDto) {
        DetallePedidoModel objectModel = objectRequestMapper.toObject(objectRequestDto);
        return objectResponseMapper.toResponse(objectServicePort.updateObject(objectModel));
    }

    @Override
    public DetallePedidoResponseDto findById(Long id) {
        return objectResponseMapper.toResponse(objectServicePort.findById(id));
    }
   
    
}
