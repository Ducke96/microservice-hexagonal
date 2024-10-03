package com.usuario.usuario.domain.spi;

import java.util.List;

import com.usuario.usuario.domain.model.DetallePedidoModel;

public interface IDetallePedidoPersistencePort {
    DetallePedidoModel saveObject(DetallePedidoModel objectModel);
    List<DetallePedidoModel> getAllObjects();
    DetallePedidoModel updateObject(DetallePedidoModel objectModel);
    DetallePedidoModel findById(Long id);
}
