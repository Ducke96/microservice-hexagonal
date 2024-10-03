package com.usuario.usuario.application.dto.request;

import com.usuario.usuario.infrastructure.out.jpa.entity.Restaurante;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlatoRequestDto {
    private Long id;
    private String nombre;
    private int precio;
    private String descripcion;
    private String categoria;
    private String url;
    private char estado;
    private Restaurante restaurante;
}
