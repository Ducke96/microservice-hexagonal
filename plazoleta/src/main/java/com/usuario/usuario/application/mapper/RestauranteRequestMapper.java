package com.usuario.usuario.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.usuario.usuario.application.dto.request.RestauranteRequestDto;
import com.usuario.usuario.domain.model.RestauranteModel;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RestauranteRequestMapper {
    RestauranteModel toObject(RestauranteRequestDto objectRequestDto);
}
