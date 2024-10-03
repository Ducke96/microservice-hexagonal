package com.usuario.usuario.application.mapper;

import com.usuario.usuario.application.dto.request.UsuarioRequestDto;
import com.usuario.usuario.domain.model.UsuarioModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UsuarioRequestMapper {
    UsuarioModel toObject(UsuarioRequestDto objectRequestDto);
}
