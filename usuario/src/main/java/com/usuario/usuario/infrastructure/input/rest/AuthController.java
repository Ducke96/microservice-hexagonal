package com.usuario.usuario.infrastructure.input.rest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.usuario.usuario.domain.usecase.AuthService;
import com.usuario.usuario.infrastructure.out.jpa.entity.Role;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import com.usuario.usuario.application.dto.response.UsuarioResponseDto;
import com.usuario.usuario.application.handler.IUsuarioHandler;
import com.usuario.usuario.domain.model.AuthResponse;
import com.usuario.usuario.domain.model.LoginRequest;
import com.usuario.usuario.domain.model.RegisterRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authService;
     private final IUsuarioHandler objectHandler;
    
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }

    @Operation(summary = "Get user by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @GetMapping(value = "/user/{email}") // Define la ruta con el email como parámetro
    public ResponseEntity<UsuarioResponseDto> getUserByEmail(@PathVariable String email) {
        UsuarioResponseDto user = objectHandler.getByCorreo(email); // Implementa este método en tu handler
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping(value = "register/cliente")
    public ResponseEntity<AuthResponse> registerCliente(@RequestBody RegisterRequest request)
    {
        request.setRole(Role.CLIENTE);
        return ResponseEntity.ok(authService.register(request));
    }

}