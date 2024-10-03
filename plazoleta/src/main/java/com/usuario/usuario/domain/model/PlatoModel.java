package com.usuario.usuario.domain.model;

import com.usuario.usuario.infrastructure.out.jpa.entity.Restaurante;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlatoModel {
    
    private Long id;
    private String nombre;
    private int precio;
    private String descripcion;
    private String categoria;
    private String url;
    private char estado;
    private Restaurante restaurante;

}
