package com.service.users.infrastucture.input.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.users.application.dto.owner.OwnerRequestDto;
import com.service.users.application.dto.owner.OwnerResponseDto;
import com.service.users.application.handler.OwnerHandler;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/owner")
@RequiredArgsConstructor
public class OwnerController {
   
    private final OwnerHandler ownerHandler;

    @Operation(summary = "Registrar nuevo propietario", description = "Registra un nuevo propietario en el sistema.")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody OwnerRequestDto registerRequestDto) {
        ownerHandler.saveUser(registerRequestDto);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    @Operation(summary = "Obtener propietario por ID", description = "Obtiene los detalles de un propietario específico.")
    @GetMapping("/{idOwner}")
    public ResponseEntity<OwnerResponseDto> getOwnerBiId(@PathVariable Long idOwner,  @RequestHeader("Authorization") String authorizationHeader) {
        OwnerResponseDto owner = ownerHandler.findUserById(idOwner);
        return ResponseEntity.status(HttpStatus.OK).body(owner);
    }
}
