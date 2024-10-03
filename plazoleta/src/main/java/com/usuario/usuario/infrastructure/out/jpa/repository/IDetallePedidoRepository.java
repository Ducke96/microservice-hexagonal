package com.usuario.usuario.infrastructure.out.jpa.repository;
import com.usuario.usuario.infrastructure.out.jpa.entity.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetallePedidoRepository extends JpaRepository<DetallePedido, Long>{
    
}
