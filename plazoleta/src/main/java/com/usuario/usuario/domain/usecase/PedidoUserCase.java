package com.usuario.usuario.domain.usecase;

import java.util.List;

import com.usuario.usuario.domain.api.IPedidoServicePort;
import com.usuario.usuario.domain.model.PedidoModel;
import com.usuario.usuario.domain.spi.IPedidoPersistencePort;

public class PedidoUserCase implements IPedidoServicePort {
    private final IPedidoPersistencePort objectPersistencePort;

    public PedidoUserCase(IPedidoPersistencePort objectPersistencePort) {
        this.objectPersistencePort = objectPersistencePort;
    }

    @Override
    public void saveObject(PedidoModel objectModel) {
        objectPersistencePort.saveObject(objectModel);
    }

    @Override
    public List<PedidoModel> getAllObjects() {
        return objectPersistencePort.getAllObjects();
    }

    @Override
    public PedidoModel updateObject(PedidoModel objectModel) {
        return objectPersistencePort.updateObject(objectModel);
    }

    @Override
    public PedidoModel findById(Long id) {
        return objectPersistencePort.findById(id);
    }

}
