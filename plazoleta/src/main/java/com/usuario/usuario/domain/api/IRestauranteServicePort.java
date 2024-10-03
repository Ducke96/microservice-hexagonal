package com.usuario.usuario.domain.api;
import java.util.List;

import com.usuario.usuario.domain.model.RestauranteModel;

public interface IRestauranteServicePort {

    void saveObject(RestauranteModel objectModel , String token);
    List<RestauranteModel> getAllObjects();
    RestauranteModel findById(Long id);
    List<RestauranteModel> getAllObjectsOrderby(int numElementos);
}
