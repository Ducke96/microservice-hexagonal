package com.usuario.usuario.infrastructure.out.jpa.repository;

import com.usuario.usuario.infrastructure.out.jpa.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByCorreo(String correo); 
}