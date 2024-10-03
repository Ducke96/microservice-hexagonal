package com.usuario.usuario.application.mapper;

import com.usuario.usuario.application.dto.response.UsuarioResponseDto;
import com.usuario.usuario.domain.model.UsuarioModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UsuarioResponseMapper {
    UsuarioResponseDto toResponse(UsuarioModel objectModel);

    List<UsuarioResponseDto> toResponseList(List<UsuarioModel> objectModelList);
}
