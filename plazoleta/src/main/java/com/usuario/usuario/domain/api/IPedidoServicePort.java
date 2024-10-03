package com.usuario.usuario.domain.api;

import java.util.List;

import com.usuario.usuario.domain.model.PedidoModel;

public interface IPedidoServicePort {
    void saveObject(PedidoModel objectModel);
    List<PedidoModel> getAllObjects();
    PedidoModel updateObject(PedidoModel objectModel);
    PedidoModel findById(Long id);
}
