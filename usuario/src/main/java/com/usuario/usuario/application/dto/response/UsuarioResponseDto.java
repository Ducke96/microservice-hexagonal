package com.usuario.usuario.application.dto.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
