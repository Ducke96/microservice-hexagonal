package com.usuario.usuario.application.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class RestauranteRequestDto {
    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;
    private String url;
    private Long idpropietario;  
}
