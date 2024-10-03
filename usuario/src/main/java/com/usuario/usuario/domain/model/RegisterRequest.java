package com.usuario.usuario.domain.model;
import java.util.Date;

import com.usuario.usuario.infrastructure.out.jpa.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String firstname;
    String lastname;
    int numIdentidad;
    String celular;
    Date fechaNacimiento;
    String correo;
    String clave;
    Role role;
}