package com.usuario.usuario.infrastructure.input.rest;

import com.usuario.usuario.application.dto.request.UsuarioRequestDto;
import com.usuario.usuario.application.dto.response.UsuarioResponseDto;
import com.usuario.usuario.application.handler.IUsuarioHandler;
import com.usuario.usuario.infrastructure.out.jpa.entity.Role;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
 

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UsuarioRestController {

    private final IUsuarioHandler objectHandler;

    @Operation(summary = "Add a new object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveObject(@RequestBody UsuarioRequestDto objectRequestDto) {
        objectHandler.saveObject(objectRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all objects")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All objects returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UsuarioResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping(value = "user")
    public ResponseEntity<List<UsuarioResponseDto>> getAllObjects() {
        return ResponseEntity.ok(objectHandler.getAllObjects());
    }


    @Operation(summary = "Get user by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @GetMapping(value = "/user/{id}") // Define la ruta con el email como parámetro
    public ResponseEntity<UsuarioResponseDto> getUserByEmail(@PathVariable Long id) {
        UsuarioResponseDto user = objectHandler.getById(id); // Implementa este método en tu handler
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    @Operation(summary = "Add a new Propietario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PostMapping(value = "/userPropietario")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> saveObjectPropietario(@RequestBody UsuarioRequestDto objectRequestDto) {
        objectRequestDto.setRole(Role.PROPIETARIO);
        objectHandler.saveObject(objectRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @Operation(summary = "Add a new Propietario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PostMapping(value = "/userCliente")
    @PreAuthorize("hasRole('PROPIETARIO')")
    public ResponseEntity<Void> saveObjectCliente(@RequestBody UsuarioRequestDto objectRequestDto) {
        objectRequestDto.setRole(Role.EMPLEADO);
        objectHandler.saveObject(objectRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}