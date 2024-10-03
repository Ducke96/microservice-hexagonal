package com.usuario.usuario.infrastructure.out.jpa.adapter;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.usuario.usuario.domain.model.PlatoModel;
import com.usuario.usuario.domain.spi.IPlatoPersistencePort;
import com.usuario.usuario.infrastructure.exception.NoDataFoundException;
import com.usuario.usuario.infrastructure.jwt.CustomWebAuthenticationDetails;
import com.usuario.usuario.infrastructure.out.jpa.entity.Plato;
import com.usuario.usuario.infrastructure.out.jpa.entity.Restaurante;
import com.usuario.usuario.infrastructure.out.jpa.mapper.IPlatoEntityMapper;
import com.usuario.usuario.infrastructure.out.jpa.repository.IPlatoRepository;
import com.usuario.usuario.infrastructure.out.jpa.repository.IRestauranteRepository;
import org.springframework.security.core.Authentication;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlatoJpaAdapter implements IPlatoPersistencePort{
    private final IPlatoRepository objectRepository;
    private final IPlatoEntityMapper objectEntityMapper;
    private final IRestauranteRepository restauranteRepository;


    @Override
    public PlatoModel saveObject(PlatoModel objectModel) {
    
        Plato objectEntity = objectRepository.save(objectEntityMapper.toEntity(objectModel));
        return objectEntityMapper.toObjectModel(objectEntity);
    }

    @Override
    public List<PlatoModel> getAllObjects() {
        List<Plato> entityList = objectRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return objectEntityMapper.toObjectModelList(entityList);
    }


    @Override
    public PlatoModel updateObject(PlatoModel objectModel) {  
        PlatoModel platobd = findById(objectModel.getId());
        platobd.setPrecio(objectModel.getPrecio());
        platobd.setDescripcion(objectModel.getDescripcion());
        Plato objectEntity = objectRepository.save(objectEntityMapper.toEntity(platobd));
        return objectEntityMapper.toObjectModel(objectEntity);
    }

    @Override
    public PlatoModel findById(Long id) {
        Optional<Plato> entity = objectRepository.findById(id);
        if (entity.isEmpty()) {
            throw new UsernameNotFoundException("Plato not fournd");
        }
        return objectEntityMapper.toObjectModel(entity.get());
    }

    @Override
    public PlatoModel habilitarObject(PlatoModel objectModel) { 
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomWebAuthenticationDetails customDetails = (CustomWebAuthenticationDetails) authentication.getDetails();
        
        PlatoModel platobd = findById(objectModel.getId());
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

    
}
