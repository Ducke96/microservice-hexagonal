package com.usuario.usuario.infrastructure.configuration;

import com.usuario.usuario.domain.api.IUsuarioServicePort;
import com.usuario.usuario.domain.spi.IUsuarioPersistencePort;
import com.usuario.usuario.domain.usecase.UsuarioUseCase;
import com.usuario.usuario.infrastructure.out.jpa.adapter.UsuarioJpaAdapter;
import com.usuario.usuario.infrastructure.out.jpa.mapper.IUsuarioEntityMapper;
import com.usuario.usuario.infrastructure.out.jpa.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUsuarioRepository objectRepository;
    private final IUsuarioEntityMapper objectEntityMapper;
     private final PasswordEncoder passwordEncoder;

    @Bean
    public IUsuarioPersistencePort objectPersistencePort() {
        return new UsuarioJpaAdapter(objectRepository, objectEntityMapper);
    }

    @Bean
    public IUsuarioServicePort objectServicePort() {
        return new UsuarioUseCase(objectPersistencePort(),passwordEncoder);
    }
}