package com.usuario.usuario.infrastructure.out.jpa.mapper;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.usuario.usuario.domain.model.DetallePedidoModel;
import com.usuario.usuario.infrastructure.out.jpa.entity.DetallePedido;
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IDetallePedidoEntityMapper {
    DetallePedido toEntity(DetallePedidoModel pedido);
    DetallePedidoModel toObjectModel(DetallePedido objectEntity);
    List<DetallePedidoModel> toObjectModelList(List<DetallePedido> pedidoEntityList);
}
