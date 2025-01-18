package com.service.users.infrastucture.input.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.users.application.dto.RoleRequestDto;
import com.service.users.application.handler.RoleHandler;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleHandler roleHandler;

    @Operation(summary = "Buscar rol por nombre", description = "Obtiene un rol específico por su nombre.")
    @GetMapping("/{name}")
    public ResponseEntity<RoleRequestDto> findByName(@PathVariable String name) {
        RoleRequestDto roleRequestDto = roleHandler.findByName(name);
        return ResponseEntity.ok(roleRequestDto);
    }

    @Operation(summary = "Registrar nuevo rol", description = "Crea un nuevo rol en el sistema.")
    @PostMapping
    public ResponseEntity<RoleRequestDto> save(@RequestBody RoleRequestDto roleRequestDto) {
        RoleRequestDto savedRole = roleHandler.save(roleRequestDto);
        return ResponseEntity.ok(savedRole);
    }
}
