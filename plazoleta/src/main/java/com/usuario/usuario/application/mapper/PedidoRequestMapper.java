package com.usuario.usuario.application.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.usuario.usuario.application.dto.request.PedidoRequestDto;
import com.usuario.usuario.domain.model.PedidoModel;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PedidoRequestMapper {
    PedidoModel toObject(PedidoRequestDto objectRequestDto);
}
