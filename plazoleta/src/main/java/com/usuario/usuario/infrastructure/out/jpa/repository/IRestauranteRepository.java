package com.usuario.usuario.infrastructure.out.jpa.repository;

import com.usuario.usuario.infrastructure.out.jpa.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestauranteRepository extends JpaRepository<Restaurante, Long> {

}