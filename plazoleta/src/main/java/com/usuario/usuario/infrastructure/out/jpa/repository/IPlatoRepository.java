package com.usuario.usuario.infrastructure.out.jpa.repository;
import com.usuario.usuario.infrastructure.out.jpa.entity.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IPlatoRepository extends JpaRepository<Plato, Long>{
    
}
