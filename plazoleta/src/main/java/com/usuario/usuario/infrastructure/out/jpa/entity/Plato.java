package com.usuario.usuario.infrastructure.out.jpa.entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "plato")
public class Plato {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idplato", nullable = false)
    private Long id;
    private String nombre;
    private int precio;
    private String descripcion;
    private String categoria;
    private String url;
    private char estado;
    @ManyToOne // Relación de muchos a uno
    @JoinColumn(name = "idrestaurante") // Columna que hace referencia a Restaurante
    private Restaurante restaurante;
    @OneToMany(mappedBy = "plato")
    private List<DetallePedido> detallePedido;
}
