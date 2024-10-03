package com.usuario.usuario.domain.api;

import java.util.List;

import com.usuario.usuario.domain.model.DetallePedidoModel;

public interface IDetallePedidoServicePort {
    void saveObject(DetallePedidoModel objectModel);
    List<DetallePedidoModel> getAllObjects();
    DetallePedidoModel updateObject(DetallePedidoModel objectModel);
    DetallePedidoModel findById(Long id); 
}
