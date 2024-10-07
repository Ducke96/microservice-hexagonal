package com.usuario.usuario.infrastructure.configuration;

import com.usuario.usuario.domain.api.IUsuarioServicePort;
import com.usuario.usuario.domain.api.IRestauranteServicePort;
import com.usuario.usuario.domain.api.IPlatoServicePort;
import com.usuario.usuario.domain.api.IPedidoServicePort;
import com.usuario.usuario.application.handler.impl.SmsService;
import com.usuario.usuario.domain.api.IDetallePedidoServicePort;
import com.usuario.usuario.domain.spi.IUsuarioPersistencePort;
import com.usuario.usuario.domain.spi.IRestaurantePersistencePort;
import com.usuario.usuario.domain.spi.IPlatoPersistencePort;
import com.usuario.usuario.domain.spi.IPedidoPersistencePort;
import com.usuario.usuario.domain.spi.IDetallePedidoPersistencePort;
import com.usuario.usuario.domain.usecase.UsuarioUseCase;
import com.usuario.usuario.domain.usecase.PlatoUserCase;
import com.usuario.usuario.domain.usecase.PedidoUserCase;
import com.usuario.usuario.domain.usecase.DetallePedidoUserCase;
import com.usuario.usuario.domain.usecase.RestauranteUserCase;
import com.usuario.usuario.infrastructure.out.jpa.adapter.UsuarioJpaAdapter;
import com.usuario.usuario.infrastructure.out.jpa.adapter.RestauranteJpaAdapter;
import com.usuario.usuario.infrastructure.out.jpa.adapter.PlatoJpaAdapter;
import com.usuario.usuario.infrastructure.out.jpa.adapter.PedidoJpaAdapter;
import com.usuario.usuario.infrastructure.out.jpa.adapter.DetallePedidoJpaAdapter;
import com.usuario.usuario.infrastructure.out.jpa.mapper.IUsuarioEntityMapper;
import com.usuario.usuario.infrastructure.out.jpa.repository.IUsuarioRepository;
import com.usuario.usuario.infrastructure.out.jpa.mapper.IRestauranteEntityMapper;
import com.usuario.usuario.infrastructure.out.jpa.repository.IRestauranteRepository;
import com.usuario.usuario.infrastructure.out.jpa.repository.IPlatoRepository;
import com.usuario.usuario.infrastructure.out.jpa.mapper.IPlatoEntityMapper;
import com.usuario.usuario.infrastructure.out.jpa.repository.IPedidoRepository;
import com.usuario.usuario.infrastructure.out.jpa.mapper.IPedidoEntityMapper;
import com.usuario.usuario.infrastructure.out.jpa.repository.IDetallePedidoRepository;
import com.usuario.usuario.infrastructure.out.jpa.repository.IAuditoriaPedidoRepository;
import com.usuario.usuario.infrastructure.out.jpa.mapper.IDetallePedidoEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUsuarioRepository objectRepository;
    private final IUsuarioEntityMapper objectEntityMapper;
    private final IRestauranteRepository restauranteRepository;
    private final IRestauranteEntityMapper restauranteEntityMapper;
    private final IPlatoRepository platoRepository;
    private final IPlatoEntityMapper platoEntityMapper;
    private final IPedidoRepository pedidoRepository;
    private final IPedidoEntityMapper pedidoEntityMapper;
    private final IDetallePedidoRepository detallePedidoRepository;
    private final IDetallePedidoEntityMapper detallePedidoEntityMapper;
    private final IAuditoriaPedidoRepository iAuditoriaPedidoRepository;

    @Bean
    public IUsuarioPersistencePort objectPersistencePort() {
        return new UsuarioJpaAdapter(objectRepository, objectEntityMapper, restTemplate());
    }

    @Bean
    public IUsuarioServicePort objectServicePort() {
        return new UsuarioUseCase(objectPersistencePort());
    }

    @Bean
    public IRestaurantePersistencePort restaurantePersistencePort() {
        return new RestauranteJpaAdapter(restauranteRepository, restauranteEntityMapper);
    }

    @Bean
    public IRestauranteServicePort restauranteServicePort() {
        return new RestauranteUserCase(restaurantePersistencePort());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IPlatoPersistencePort platoPersistencePort() {
        return new PlatoJpaAdapter(platoRepository, platoEntityMapper, restauranteRepository);
    }

    @Bean
    public IPlatoServicePort platoServicePort() {
        return new PlatoUserCase(platoPersistencePort());
    }

    @Bean
    public SmsService smsService() {
        return new SmsService();
    }

    @Bean
    public IPedidoPersistencePort pedidoPersistencePort() {
        return new PedidoJpaAdapter(pedidoRepository, pedidoEntityMapper, smsService(), iAuditoriaPedidoRepository);
    }

    @Bean
    public IPedidoServicePort pedidoServicePort() {
        return new PedidoUserCase(pedidoPersistencePort());
    }

    @Bean
    public IDetallePedidoPersistencePort detallePedidoPersistencePort() {
        return new DetallePedidoJpaAdapter(detallePedidoRepository, detallePedidoEntityMapper);
    }

    @Bean
    public IDetallePedidoServicePort detallePedidoServicePort() {
        return new DetallePedidoUserCase(detallePedidoPersistencePort());
    }

}