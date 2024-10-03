package com.usuario.usuario.infrastructure.out.jpa.mapper;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.usuario.usuario.domain.model.PedidoModel;
import com.usuario.usuario.infrastructure.out.jpa.entity.Pedido;
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IPedidoEntityMapper {
    Pedido toEntity(PedidoModel pedido);
    PedidoModel toObjectModel(Pedido objectEntity);
    List<PedidoModel> toObjectModelList(List<Pedido> pedidoEntityList);
}
