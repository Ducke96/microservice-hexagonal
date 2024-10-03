package com.usuario.usuario.infrastructure.input.rest;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.usuario.usuario.application.dto.request.PlatoRequestDto;
import com.usuario.usuario.application.dto.response.PlatoResponseDto;
import com.usuario.usuario.application.handler.IPlatoHandler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor

public class PlatoController {

    private final IPlatoHandler objectHandler;

    @Operation(summary = "Add a new object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PostMapping(value = "plato")
    public ResponseEntity<Void> saveObject(@RequestBody PlatoRequestDto objectRequestDto,
            @RequestHeader("Authorization") String token) {

        objectHandler.saveObject(objectRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all objects")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All objects returned", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PlatoResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping(value = "plato")
    public ResponseEntity<List<PlatoResponseDto>> getAllObjects() {
        return ResponseEntity.ok(objectHandler.getAllObjects());
    }



    @Operation(summary = "Get object by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "object returned by id", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PlatoResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping(value = "plato/{id}")
    public ResponseEntity<PlatoResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(objectHandler.findById(id));
    }


    @Operation(summary = "update a object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PatchMapping(value = "plato/{id}")
    public ResponseEntity<Void> updateObject(@RequestBody PlatoRequestDto objectRequestDto,
            @RequestHeader("Authorization") String token,@PathVariable Long id) {

        objectHandler.updateObject(objectRequestDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @Operation(summary = "update a object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PatchMapping(value = "plato/habilitar/{id}")
    public ResponseEntity<Void> habilitarObject(
            @RequestHeader("Authorization") String token,@PathVariable Long id) {
        PlatoRequestDto objectRequestDto = new PlatoRequestDto();
        objectRequestDto.setId(id);
        objectRequestDto.setEstado('A');
        objectHandler.habilitarObject(objectRequestDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }



    @Operation(summary = "update a object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PatchMapping(value = "plato/deshabilitar/{id}")
    public ResponseEntity<Void> deshabilitarObject(
            @RequestHeader("Authorization") String token,@PathVariable Long id) {
        PlatoRequestDto objectRequestDto = new PlatoRequestDto();
        objectRequestDto.setId(id);
        objectRequestDto.setEstado('I');
        objectHandler.habilitarObject(objectRequestDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
