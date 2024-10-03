package com.usuario.usuario.application.dto.response;

import java.util.List;

import com.usuario.usuario.infrastructure.out.jpa.entity.DetallePedido;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponseDto {

    private int idrestaurante;
    private String estado;
    private String user;
    private List<DetallePedidoResponseDto> detallePedido;
}
