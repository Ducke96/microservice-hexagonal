package com.usuario.usuario.domain.usecase;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.usuario.usuario.infrastructure.jwt.JwtService;
import com.usuario.usuario.infrastructure.out.jpa.entity.Role;
import com.usuario.usuario.infrastructure.out.jpa.entity.Usuario;
import com.usuario.usuario.infrastructure.out.jpa.repository.IUsuarioRepository;
import com.usuario.usuario.domain.model.AuthResponse;
import com.usuario.usuario.domain.model.LoginRequest;
import com.usuario.usuario.domain.model.RegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final IUsuarioRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        Usuario user=userRepository.findByCorreo(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();

    }

    public AuthResponse register(RegisterRequest request) {
        Usuario user = Usuario.builder()
            .nombre(request.getFirstname())
            .clave(passwordEncoder.encode( request.getClave()))
            .nombre(request.getFirstname())
            .apellido(request.getLastname())
            .celular(request.getCelular())
            .correo(request.getCorreo())
            .fechaNacimiento(request.getFechaNacimiento())
            .numIdentidad(request.getNumIdentidad())
            .role(Role.ADMIN)
            .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
        
    }

}