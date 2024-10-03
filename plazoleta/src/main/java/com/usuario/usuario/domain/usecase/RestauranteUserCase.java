package com.usuario.usuario.domain.usecase;
import com.usuario.usuario.domain.api.IRestauranteServicePort;
import com.usuario.usuario.domain.model.RestauranteModel;
import com.usuario.usuario.domain.spi.IRestaurantePersistencePort;

import java.util.List;


public class RestauranteUserCase implements IRestauranteServicePort{
     private final IRestaurantePersistencePort objectPersistencePort;

    public RestauranteUserCase(IRestaurantePersistencePort objectPersistencePort) {
        this.objectPersistencePort = objectPersistencePort;
    }

    @Override
    public void saveObject(RestauranteModel objectModel , String token) {
        objectPersistencePort.saveObject(objectModel , token);
    }

    @Override
    public List<RestauranteModel> getAllObjects() {
        return objectPersistencePort.getAllObjects();
    }

    @Override
    public  RestauranteModel findById(Long id) {
        return objectPersistencePort.findById(id);
    }

    @Override
    public List<RestauranteModel> getAllObjectsOrderby(int numElementos) {
        return objectPersistencePort.getAllObjectsOrderby(numElementos);
    }

}
