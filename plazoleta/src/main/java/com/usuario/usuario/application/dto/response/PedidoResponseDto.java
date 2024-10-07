package com.usuario.usuario.application.dto.response;

import java.util.List;

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
    private String codigo;
    private List<DetallePedidoResponseDto> detallePedido;
}
