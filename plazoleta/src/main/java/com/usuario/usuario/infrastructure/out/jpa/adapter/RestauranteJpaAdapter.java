package com.usuario.usuario.infrastructure.out.jpa.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import com.usuario.usuario.domain.model.RestauranteModel;
import com.usuario.usuario.domain.spi.IRestaurantePersistencePort;
import com.usuario.usuario.infrastructure.exception.NoDataFoundException;
import com.usuario.usuario.infrastructure.out.jpa.entity.Restaurante;
import com.usuario.usuario.infrastructure.out.jpa.mapper.IRestauranteEntityMapper;
import com.usuario.usuario.infrastructure.out.jpa.repository.IRestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@RequiredArgsConstructor
public class RestauranteJpaAdapter implements IRestaurantePersistencePort{
    private final IRestauranteRepository objectRepository;
    private final IRestauranteEntityMapper objectEntityMapper;


    @Override
    public RestauranteModel saveObject(RestauranteModel objectModel , String token) {
    
        Restaurante objectEntity = objectRepository.save(objectEntityMapper.toEntity(objectModel));
        return objectEntityMapper.toObjectModel(objectEntity);
    }

    @Override
    public List<RestauranteModel> getAllObjects() {
        List<Restaurante> entityList = objectRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return objectEntityMapper.toObjectModelList(entityList);
    }


    @Override
    public RestauranteModel findById(Long id) {
        Optional<Restaurante> entity = objectRepository.findById(id);
        if (entity.isEmpty()) {
            throw new  UsernameNotFoundException("User not fournd");
        }
        return objectEntityMapper.toObjectModel(entity.get());
    }

    @Override
    public List<RestauranteModel> getAllObjectsOrderby(int numElementos) {
        Pageable pageable = PageRequest.of(0, numElementos, Sort.by("nombre").ascending());
        List<Restaurante> entityList = objectRepository.findAll(pageable).getContent();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return objectEntityMapper.toObjectModelList(entityList);
    }
}
