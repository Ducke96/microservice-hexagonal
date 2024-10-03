package com.usuario.usuario.infrastructure.out.jpa.entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurante")
public class Restaurante {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idrestaurante", nullable = false)
    private Long id;
    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;
    private String url;
    private Long idpropietario;
    @OneToMany(mappedBy = "restaurante")
    private List<Plato> platos;    
       
}
