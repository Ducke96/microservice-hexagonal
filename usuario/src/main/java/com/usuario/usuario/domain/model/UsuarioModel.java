package com.usuario.usuario.domain.model;

import java.util.Date;

import com.usuario.usuario.infrastructure.out.jpa.entity.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {
    private Long id;
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
