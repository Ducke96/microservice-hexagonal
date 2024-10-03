package com.usuario.usuario.infrastructure.out.jpa.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.usuario.usuario.domain.model.DetallePedidoModel;
import com.usuario.usuario.domain.spi.IDetallePedidoPersistencePort;
import com.usuario.usuario.infrastructure.exception.NoDataFoundException;
import com.usuario.usuario.infrastructure.out.jpa.entity.DetallePedido;
import com.usuario.usuario.infrastructure.out.jpa.mapper.IDetallePedidoEntityMapper;
import com.usuario.usuario.infrastructure.out.jpa.repository.IDetallePedidoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DetallePedidoJpaAdapter implements IDetallePedidoPersistencePort{
    private final IDetallePedidoRepository objectRepository;
    private final IDetallePedidoEntityMapper objectEntityMapper;
    //private final IRestauranteRepository restauranteRepository;


    @Override
    public DetallePedidoModel saveObject(DetallePedidoModel objectModel) {
    
        DetallePedido objectEntity = objectRepository.save(objectEntityMapper.toEntity(objectModel));
        return objectEntityMapper.toObjectModel(objectEntity);
    }

    @Override
    public List<DetallePedidoModel> getAllObjects() {
        List<DetallePedido> entityList = objectRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return objectEntityMapper.toObjectModelList(entityList);
    }


    @Override
    public DetallePedidoModel updateObject(DetallePedidoModel objectModel) {  
        DetallePedidoModel platobd = findById(objectModel.getId());
        //platobd.setPrecio(objectModel.getPrecio());
        //platobd.setDescripcion(objectModel.getDescripcion());
        DetallePedido objectEntity = objectRepository.save(objectEntityMapper.toEntity(platobd));
        return objectEntityMapper.toObjectModel(objectEntity);
    }

    @Override
    public DetallePedidoModel findById(Long id) {
        Optional<DetallePedido> entity = objectRepository.findById(id);
        if (entity.isEmpty()) {
            throw new UsernameNotFoundException("Plato not fournd");
        }
        return objectEntityMapper.toObjectModel(entity.get());
    }

 /*
   @Override
    public PedidoModel habilitarObject(PedidoModel objectModel) { 
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomWebAuthenticationDetails customDetails = (CustomWebAuthenticationDetails) authentication.getDetails();
        
        PedidoModel platobd = findById(objectModel.getId());
        Optional<Restaurante> restaurante = restauranteRepository.findById(platobd.getRestaurante().getId());
        if (restaurante.isEmpty()) {
            throw new  UsernameNotFoundException("Restaurante not fournd");
        }
        if (!restaurante.get().getId().equals(customDetails.getUserId())) {
            throw new NoDataFoundException();
        }
        platobd.setEstado(objectModel.getEstado());
        Plato objectEntity = objectRepository.save(objectEntityMapper.toEntity(platobd));
        return objectEntityMapper.toObjectModel(objectEntity);
    }
  */
    
}
