package com.usuario.usuario.application.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.usuario.usuario.application.dto.request.DetallePedidoResquestDto;
import com.usuario.usuario.domain.model.DetallePedidoModel;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DetallePedidoRequestMapper {
    DetallePedidoModel toObject(DetallePedidoResquestDto objectRequestDto);
}
