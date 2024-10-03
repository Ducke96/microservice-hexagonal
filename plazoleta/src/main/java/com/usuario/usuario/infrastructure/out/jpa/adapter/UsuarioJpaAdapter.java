package com.usuario.usuario.infrastructure.out.jpa.adapter;

import com.usuario.usuario.domain.model.UsuarioModel;
import com.usuario.usuario.domain.spi.IUsuarioPersistencePort;
import com.usuario.usuario.infrastructure.exception.NoDataFoundException;
import com.usuario.usuario.infrastructure.out.jpa.entity.Usuario;
import com.usuario.usuario.infrastructure.out.jpa.mapper.IUsuarioEntityMapper;
import com.usuario.usuario.infrastructure.out.jpa.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class UsuarioJpaAdapter implements IUsuarioPersistencePort {

    private final IUsuarioRepository objectRepository;
    private final IUsuarioEntityMapper objectEntityMapper;
    private final RestTemplate restTemplate;
    private final String urlGetuser = "http://localhost:8081/auth/user/"; // Cambia a tu URL
    private final String urlGetuserById = "http://localhost:8081/api/v1/user/";

    @Override
    public UsuarioModel saveObject(UsuarioModel objectModel) {
        Usuario objectEntity = objectRepository.save(objectEntityMapper.toEntity(objectModel));
        return objectEntityMapper.toObjectModel(objectEntity);
    }

    @Override
    public List<UsuarioModel> getAllObjects() {
        List<Usuario> entityList = objectRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return objectEntityMapper.toObjectModelList(entityList);
    }


    @Override
    public Optional<Usuario> findByCorreo(String email) {
        HttpHeaders headers = new HttpHeaders();
        //headers.set("Authorization", "Bearer " + "");

        // Crear la entidad HTTP con los headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Hacer la llamada GET
        ResponseEntity<Usuario> response = restTemplate.exchange(
                urlGetuser+email,
                HttpMethod.GET,
                entity,
                Usuario.class
        );

        return Optional.ofNullable(response.getBody());
    }

    @Override
    public Optional<UsuarioModel> findById(Long id, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        // Crear la entidad HTTP con los headers
        HttpEntity<String> entity = new HttpEntity<>(headers);
        // Hacer la llamada GET
        ResponseEntity<Usuario> response = restTemplate.exchange(
                urlGetuserById+id,
                HttpMethod.GET,
                entity,
                Usuario.class
        );
        if (response.getStatusCode().isError()) {
            throw new UsernameNotFoundException("User not fournd");
        }

        return Optional.ofNullable(objectEntityMapper.toObjectModel(response.getBody()));
    }




}