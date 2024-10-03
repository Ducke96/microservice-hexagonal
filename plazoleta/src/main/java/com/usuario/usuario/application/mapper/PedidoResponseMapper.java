package com.usuario.usuario.application.mapper;
import com.usuario.usuario.application.dto.response.PedidoResponseDto;
import com.usuario.usuario.domain.model.PedidoModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PedidoResponseMapper {
    PedidoResponseDto toResponse(PedidoModel objectModel);
    List<PedidoResponseDto> toResponseList(List<PedidoModel> objectModelList);
}
