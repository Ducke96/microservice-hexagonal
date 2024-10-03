package com.usuario.usuario.infrastructure.out.jpa.repository;
import com.usuario.usuario.infrastructure.out.jpa.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface IPedidoRepository extends JpaRepository<Pedido, Long>{
    Optional<Pedido>  findByUserAndEstado(String user , String estado); 
}
