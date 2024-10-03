package com.usuario.usuario.domain.spi;

import java.util.List;

import com.usuario.usuario.domain.model.PlatoModel;

public interface IPlatoPersistencePort {
    PlatoModel saveObject(PlatoModel objectModel);
    List<PlatoModel> getAllObjects();
    PlatoModel updateObject(PlatoModel objectModel);
    PlatoModel findById(Long id);
    PlatoModel habilitarObject(PlatoModel objectModel);
}
