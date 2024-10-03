package com.usuario.usuario.application.dto.request;

import java.util.Date;

import com.usuario.usuario.infrastructure.out.jpa.entity.Role;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class UsuarioRequestDto {
    private String name;
    private String nombre;
    private String apellido;
    private int numIdentidad;
    private String celular;
    private Date fechaNacimiento;
    private String correo;
    private String clave;
    private Role role;
    
}
