package com.usuario.usuario.infrastructure.input.rest;

import com.usuario.usuario.application.dto.request.RestauranteRequestDto;
import com.usuario.usuario.application.dto.response.RestauranteResponseDto;
import com.usuario.usuario.application.handler.IRestauranteHandler;
import com.usuario.usuario.application.handler.IUsuarioHandler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
 

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RestauranteController {

    private final IRestauranteHandler objectHandler;
    private final IUsuarioHandler iUsuarioHandler;
    


    @Operation(summary = "Add a new object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PostMapping(value = "restaurante")
    public ResponseEntity<Void> saveObject(@RequestBody RestauranteRequestDto objectRequestDto , @RequestHeader("Authorization") String token) {
        
        if (iUsuarioHandler.findById(objectRequestDto.getIdpropietario(),token).isEmpty()) {
                new ResponseEntity<>("Usuario no encontrado",HttpStatus.NOT_FOUND);
        }
        objectHandler.saveObject(objectRequestDto ,  token);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all objects")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All objects returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RestauranteResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping(value = "restaurante")
    public ResponseEntity<List<RestauranteResponseDto>> getAllObjects() {
        return ResponseEntity.ok(objectHandler.getAllObjects());
    } 


    @Operation(summary = "Get all objects")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All objects returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RestauranteResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping(value = "restaurante/orderby/{numElements}")
    public ResponseEntity<List<RestauranteResponseDto>> getAllObjectsOrder(@PathVariable int numElements) {
        return ResponseEntity.ok(objectHandler.getAllObjectsOrderby(numElements));
    } 



}
