package com.usuario.usuario.infrastructure.out.jpa.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iddetalle_pedido", nullable = false)
    private Long id;
    @ManyToOne // Relación de muchos a uno
    @JoinColumn(name = "idplato") 
    private Plato plato;
    @ManyToOne // Relación de muchos a uno
    @JoinColumn(name = "idpedido") 
    private Pedido pedido;
    private int cantidad;
   
}
