package com.usuario.usuario.infrastructure.out.jpa.repository;

import com.usuario.usuario.infrastructure.out.jpa.entity.AuditoriaPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuditoriaPedidoRepository extends JpaRepository<AuditoriaPedido, Long> {

}
