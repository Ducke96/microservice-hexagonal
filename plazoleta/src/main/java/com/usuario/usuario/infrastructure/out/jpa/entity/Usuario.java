package com.usuario.usuario.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import java.util.Date;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")

public class Usuario implements UserDetails{
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idusuario", nullable = false)
    private Long id;
    private String nombre;
    private String apellido;
    private int numIdentidad;
    private String celular;
    private Date fechaNacimiento;
    private String correo;
    private String clave;

    @Enumerated(EnumType.STRING) 
    Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return List.of(new SimpleGrantedAuthority((role.name())));
    }
    @Override
    public boolean isAccountNonExpired() {
       return true;
    }
    @Override
    public boolean isAccountNonLocked() {
       return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return correo;
    }

    @Override
    public String getPassword() {
        return clave;
    }


}
