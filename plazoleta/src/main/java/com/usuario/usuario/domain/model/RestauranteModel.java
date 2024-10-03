package com.usuario.usuario.domain.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestauranteModel {
    private Long id;
    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;
    private String url;
    private Long idpropietario;  
    private List<PlatoModel> platos;
}
