package com.usuario.usuario.domain.usecase;

import java.util.List;


import com.usuario.usuario.domain.api.IPlatoServicePort;
import com.usuario.usuario.domain.spi.IPlatoPersistencePort;
import com.usuario.usuario.domain.model.PlatoModel;


public class PlatoUserCase implements IPlatoServicePort{
        private final IPlatoPersistencePort objectPersistencePort;

    public PlatoUserCase(IPlatoPersistencePort objectPersistencePort) {
        this.objectPersistencePort = objectPersistencePort;
    }

    @Override
    public void saveObject(PlatoModel objectModel) {
        objectPersistencePort.saveObject(objectModel);
    }

    @Override
    public List<PlatoModel> getAllObjects() {
        return objectPersistencePort.getAllObjects();
    } 

    @Override
    public PlatoModel updateObject(PlatoModel objectModel) {
        return objectPersistencePort.saveObject(objectModel);
    }

    @Override
    public  PlatoModel findById(Long id) {
        return objectPersistencePort.findById(id);
    }


    @Override
    public PlatoModel habilitarObject(PlatoModel objectModel) {
       return  objectPersistencePort.habilitarObject(objectModel);
    }
    
}
