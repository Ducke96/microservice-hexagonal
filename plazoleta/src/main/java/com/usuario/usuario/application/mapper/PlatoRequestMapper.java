package com.usuario.usuario.application.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.usuario.usuario.application.dto.request.PlatoRequestDto;
import com.usuario.usuario.domain.model.PlatoModel;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PlatoRequestMapper {
    PlatoModel toObject(PlatoRequestDto objectRequestDto);
}
