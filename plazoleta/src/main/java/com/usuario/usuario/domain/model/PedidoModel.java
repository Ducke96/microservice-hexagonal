package com.usuario.usuario.domain.model;

import com.usuario.usuario.infrastructure.out.jpa.entity.DetallePedido;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoModel {
    private Long id;
    private int idrestaurante;
    private String estado;
    private String user;
    private List<DetallePedidoModel> detallePedido;
}
