package com.usuario.usuario.application.handler.impl;
import com.usuario.usuario.application.dto.request.PedidoRequestDto;
import com.usuario.usuario.application.dto.response.PedidoResponseDto;
import com.usuario.usuario.application.handler.IPedidoHandler;
import com.usuario.usuario.application.mapper.PedidoRequestMapper;
import com.usuario.usuario.application.mapper.PedidoResponseMapper;
import com.usuario.usuario.domain.api.IPedidoServicePort;
import com.usuario.usuario.domain.model.PedidoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PedidoHandler implements  IPedidoHandler{
    private final IPedidoServicePort objectServicePort;
    private final PedidoRequestMapper objectRequestMapper;
    private final PedidoResponseMapper objectResponseMapper;

    @Override
    public void saveObject(PedidoRequestDto objectRequestDto) {
        PedidoModel objectModel = objectRequestMapper.toObject(objectRequestDto);
        objectServicePort.saveObject(objectModel);
    }

    @Override
    public List<PedidoResponseDto> getAllObjects() {
        return objectResponseMapper.toResponseList(objectServicePort.getAllObjects());
    }

    @Override
    public PedidoResponseDto updateObject(PedidoRequestDto objectRequestDto) {
        PedidoModel objectModel = objectRequestMapper.toObject(objectRequestDto);
        return objectResponseMapper.toResponse(objectServicePort.updateObject(objectModel));
    }

    @Override
    public PedidoResponseDto findById(Long id) {
        return objectResponseMapper.toResponse(objectServicePort.findById(id));
    }
   
    
}
