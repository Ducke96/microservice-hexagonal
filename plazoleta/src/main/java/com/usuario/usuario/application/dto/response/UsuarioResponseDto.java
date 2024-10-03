package com.usuario.usuario.application.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDto {
    private Long id;
    private String name;
    private String nombre;
    private String apellido;
    private int numIdentidad;
    private String celular;
    private Date fechaNacimiento;
    private String correo;
    private String clave;
}
