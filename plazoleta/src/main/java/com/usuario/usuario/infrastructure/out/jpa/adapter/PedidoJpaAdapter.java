package com.usuario.usuario.infrastructure.out.jpa.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.usuario.usuario.domain.model.PedidoModel;
import com.usuario.usuario.domain.spi.IPedidoPersistencePort;
import com.usuario.usuario.infrastructure.exception.NoDataFoundException;
import com.usuario.usuario.infrastructure.jwt.CustomWebAuthenticationDetails;
import com.usuario.usuario.infrastructure.out.jpa.entity.DetallePedido;
import com.usuario.usuario.infrastructure.out.jpa.entity.Pedido;
import com.usuario.usuario.infrastructure.out.jpa.mapper.IPedidoEntityMapper;
import com.usuario.usuario.infrastructure.out.jpa.repository.IPedidoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PedidoJpaAdapter implements IPedidoPersistencePort {
    private final IPedidoRepository objectRepository;
    private final IPedidoEntityMapper objectEntityMapper;
    // private final IRestauranteRepository restauranteRepository;

    @Override
    public PedidoModel saveObject(PedidoModel objectModel) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomWebAuthenticationDetails customDetails = (CustomWebAuthenticationDetails) authentication.getDetails();
        objectModel.setEstado("PENDIENTE");
        objectModel.setUser(Long.toString(customDetails.getUserId()));

        Optional<Pedido> pedidos = objectRepository.findByUserAndEstado(objectModel.getUser(), "PENDIENTE");
        if (!pedidos.isEmpty()) {
            throw new NoDataFoundException();
        }
        Pedido objectEntity = objectEntityMapper.toEntity(objectModel);
        // Establecer la relación con detallePedido
        for (DetallePedido detalle : objectEntity.getDetallePedido()) {
            detalle.setPedido(objectEntity); // Asignar el pedido al detalle
        }

        objectEntity = objectRepository.save(objectEntity);
        return objectEntityMapper.toObjectModel(objectEntity);
    }

    @Override
    public List<PedidoModel> getAllObjects() {
        List<Pedido> entityList = objectRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return objectEntityMapper.toObjectModelList(entityList);
    }

    @Override
    public PedidoModel updateObject(PedidoModel objectModel) {
        PedidoModel platobd = findById(objectModel.getId());
        // platobd.setPrecio(objectModel.getPrecio());
        // platobd.setDescripcion(objectModel.getDescripcion());
        Pedido objectEntity = objectRepository.save(objectEntityMapper.toEntity(platobd));
        return objectEntityMapper.toObjectModel(objectEntity);
    }

    @Override
    public PedidoModel findById(Long id) {
        Optional<Pedido> entity = objectRepository.findById(id);
        if (entity.isEmpty()) {
            throw new UsernameNotFoundException("Plato not fournd");
        }
        return objectEntityMapper.toObjectModel(entity.get());
    }

    /*
     * @Override
     * public PedidoModel habilitarObject(PedidoModel objectModel) {
     * Authentication authentication =
     * SecurityContextHolder.getContext().getAuthentication();
     * CustomWebAuthenticationDetails customDetails =
     * (CustomWebAuthenticationDetails) authentication.getDetails();
     * 
     * PedidoModel platobd = findById(objectModel.getId());
     * Optional<Restaurante> restaurante =
     * restauranteRepository.findById(platobd.getRestaurante().getId());
     * if (restaurante.isEmpty()) {
     * throw new UsernameNotFoundException("Restaurante not fournd");
     * }
     * if (!restaurante.get().getId().equals(customDetails.getUserId())) {
     * throw new NoDataFoundException();
     * }
     * platobd.setEstado(objectModel.getEstado());
     * Plato objectEntity =
     * objectRepository.save(objectEntityMapper.toEntity(platobd));
     * return objectEntityMapper.toObjectModel(objectEntity);
     * }
     */

}
