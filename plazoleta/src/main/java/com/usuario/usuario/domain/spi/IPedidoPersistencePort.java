package com.usuario.usuario.domain.spi;

import java.util.List;

import com.usuario.usuario.domain.model.PedidoModel;

public interface IPedidoPersistencePort {
    PedidoModel saveObject(PedidoModel objectModel);
    List<PedidoModel> getAllObjects();
    PedidoModel updateObject(PedidoModel objectModel);
    PedidoModel findById(Long id);

}
