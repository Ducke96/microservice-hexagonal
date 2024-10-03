package com.usuario.usuario.infrastructure.out.jpa.mapper;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.usuario.usuario.domain.model.PlatoModel;
import com.usuario.usuario.infrastructure.out.jpa.entity.Plato;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IPlatoEntityMapper {
    Plato toEntity(PlatoModel restaurante);
    PlatoModel toObjectModel(Plato objectEntity);
    List<PlatoModel> toObjectModelList(List<Plato> restauranteEntityList);
}
