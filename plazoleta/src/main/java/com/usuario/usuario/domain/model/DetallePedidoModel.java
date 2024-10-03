package com.usuario.usuario.domain.model;

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
public class DetallePedidoModel {

    private Long id;
    private PlatoModel plato;
    private Pedido pedido;
    private int cantidad;

}
