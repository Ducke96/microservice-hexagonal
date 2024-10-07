package com.usuario.usuario.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoResponseDto {

    private PlatoResponseDto plato;
    private int cantidad;
}
