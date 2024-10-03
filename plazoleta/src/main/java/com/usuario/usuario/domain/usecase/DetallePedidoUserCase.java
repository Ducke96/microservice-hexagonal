package com.usuario.usuario.domain.usecase;

import java.util.List;

import com.usuario.usuario.domain.api.IDetallePedidoServicePort;
import com.usuario.usuario.domain.model.DetallePedidoModel;
import com.usuario.usuario.domain.spi.IDetallePedidoPersistencePort;

public class DetallePedidoUserCase implements IDetallePedidoServicePort{
    private final IDetallePedidoPersistencePort objectPersistencePort;

    public DetallePedidoUserCase(IDetallePedidoPersistencePort objectPersistencePort) {
        this.objectPersistencePort = objectPersistencePort;
    }

    @Override
    public void saveObject(DetallePedidoModel objectModel) {
        objectPersistencePort.saveObject(objectModel);
    }

    @Override
    public List<DetallePedidoModel> getAllObjects() {
        return objectPersistencePort.getAllObjects();
    } 

    @Override
    public DetallePedidoModel updateObject(DetallePedidoModel objectModel) {
        return objectPersistencePort.saveObject(objectModel);
    }

    @Override
    public  DetallePedidoModel findById(Long id) {
        return objectPersistencePort.findById(id);
    }

      
}
