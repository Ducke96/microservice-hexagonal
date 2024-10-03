package com.usuario.usuario.infrastructure.out.jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.usuario.usuario.domain.model.RestauranteModel;
import com.usuario.usuario.infrastructure.out.jpa.entity.Restaurante;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IRestauranteEntityMapper {
    Restaurante toEntity(RestauranteModel restaurante);
    RestauranteModel toObjectModel(Restaurante objectEntity);
    List<RestauranteModel> toObjectModelList(List<Restaurante> restauranteEntityList);
}
