package com.usuario.usuario.application.dto.request;

import com.usuario.usuario.infrastructure.out.jpa.entity.Pedido;
import com.usuario.usuario.infrastructure.out.jpa.entity.Plato;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoResquestDto {
    private Long id;
    private Plato plato;
    private Pedido pedido;
    private int cantidad;
}
