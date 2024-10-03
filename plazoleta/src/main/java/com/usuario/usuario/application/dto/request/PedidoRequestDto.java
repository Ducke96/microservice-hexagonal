package com.usuario.usuario.application.dto.request;
import java.util.List;
import com.usuario.usuario.infrastructure.out.jpa.entity.DetallePedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequestDto {
    private Long id;
    private int idrestaurante;
    private String estado;
    private String user;
    private List<DetallePedido> detallePedido;
}
