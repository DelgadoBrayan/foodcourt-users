package com.service.users.infrastucture.input.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.users.application.dto.auth.AuthRequestDto;
import com.service.users.application.dto.auth.AuthResponseDto;
import com.service.users.application.handler.AuthenticationHandler;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationHandler authHandler;

    @Operation(summary = "Iniciar sesión", description = "Autentica al usuario con las credenciales proporcionadas.")
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody AuthRequestDto loginRequestDto) {
        AuthResponseDto response = authHandler.login(loginRequestDto);
        return ResponseEntity.ok(response);
    }
}
