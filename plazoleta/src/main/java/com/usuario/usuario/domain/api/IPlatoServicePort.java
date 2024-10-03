package com.usuario.usuario.domain.api;

import java.util.List;

import com.usuario.usuario.domain.model.PlatoModel;

public interface IPlatoServicePort {
    void saveObject(PlatoModel objectModel);
    List<PlatoModel> getAllObjects();
    PlatoModel updateObject(PlatoModel objectModel);
    PlatoModel habilitarObject(PlatoModel objectModel);
    PlatoModel findById(Long id);

}
