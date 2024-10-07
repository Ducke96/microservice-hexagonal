package com.usuario.usuario.infrastructure.out.jpa.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.usuario.usuario.application.handler.impl.SmsService;
import com.usuario.usuario.domain.model.PedidoModel;
import com.usuario.usuario.domain.spi.IPedidoPersistencePort;
import com.usuario.usuario.infrastructure.exception.NoDataFoundException;
import com.usuario.usuario.infrastructure.exception.ObjetNotFoundException;
import com.usuario.usuario.infrastructure.jwt.CustomWebAuthenticationDetails;
import com.usuario.usuario.infrastructure.out.jpa.entity.DetallePedido;
import com.usuario.usuario.infrastructure.out.jpa.entity.Pedido;
import com.usuario.usuario.infrastructure.out.jpa.entity.AuditoriaPedido;
import com.usuario.usuario.infrastructure.out.jpa.mapper.IPedidoEntityMapper;
import com.usuario.usuario.infrastructure.out.jpa.repository.IPedidoRepository;
import com.usuario.usuario.infrastructure.out.jpa.repository.IAuditoriaPedidoRepository;
import com.usuario.usuario.infrastructure.out.jpa.repository.IDetallePedidoRepository;

import java.util.Random;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class PedidoJpaAdapter implements IPedidoPersistencePort {

    private final IPedidoRepository objectRepository;
    private final IPedidoEntityMapper objectEntityMapper;
    private final SmsService smsService;
    private final IAuditoriaPedidoRepository iAuditoriaPedidoRepository;

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

        AuditoriaPedido auditoria = new AuditoriaPedido();
        auditoria.setEstado(objectEntity.getEstado());
        auditoria.setIdpedido(objectEntity.getId());
        auditoria.setFecha(LocalDateTime.now());
        iAuditoriaPedidoRepository.save(auditoria);
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
        PedidoModel pedidoBd = findById(objectModel.getId());

        if (pedidoBd.getEstado().equals("PENDIENTE") && objectModel.getEstado().equals("LISTO")) {
            pedidoBd.setEstado(objectModel.getEstado());
            int randomNumber = generateRandomNumber(6);
            smsService.sendSms("+573126029138", "su codigo de cormirmacion es :" + randomNumber);
            pedidoBd.setCodigo(Integer.toString(randomNumber));
        } else if (!pedidoBd.getEstado().equals("ENTREGADO") && objectModel.getEstado().equals("LISTO")) {
            throw new ObjetNotFoundException("Su pedido no puede pasar a LISTO");
        } else if (!pedidoBd.getEstado().equals("PENDIENTE") && objectModel.getEstado().equals("CANCELADO")) {
            throw new ObjetNotFoundException("Su pedido ya no se puede cancelar");
        }
        pedidoBd.setEstado(objectModel.getEstado());
        Pedido objectEntity = objectRepository.save(objectEntityMapper.toEntity(pedidoBd));
        AuditoriaPedido auditoria = new AuditoriaPedido();
        auditoria.setEstado(objectEntity.getEstado());
        auditoria.setIdpedido(objectEntity.getId());
        auditoria.setFecha(LocalDateTime.now());
        iAuditoriaPedidoRepository.save(auditoria);
        return objectEntityMapper.toObjectModel(objectEntity);
    }

    @Override
    public PedidoModel findById(Long id) {
        Optional<Pedido> entity = objectRepository.findById(id);
        if (entity.isEmpty()) {
            throw new ObjetNotFoundException("pedido not fournd");
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
    public static int generateRandomNumber(int digits) {
        // Rango de números de 6 dígitos: 100000 a 999999
        Random random = new Random();
        return random.nextInt(900000) + 100000; // Esto asegura que siempre tenga 6 dígitos
    }

}
