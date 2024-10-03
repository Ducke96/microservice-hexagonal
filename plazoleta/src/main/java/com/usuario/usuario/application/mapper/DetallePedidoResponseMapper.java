package com.usuario.usuario.application.mapper;
import com.usuario.usuario.application.dto.response.DetallePedidoResponseDto;
import com.usuario.usuario.domain.model.DetallePedidoModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DetallePedidoResponseMapper {
    DetallePedidoResponseDto toResponse(DetallePedidoModel objectModel);
    List<DetallePedidoResponseDto> toResponseList(List<DetallePedidoModel> objectModelList);
}
