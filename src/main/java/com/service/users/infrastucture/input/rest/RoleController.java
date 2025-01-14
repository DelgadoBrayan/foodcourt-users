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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleHandler roleHandler;

    @GetMapping("/{name}")
    public ResponseEntity<RoleRequestDto> findByName(@PathVariable String name) {
        RoleRequestDto roleRequestDto = roleHandler.findByName(name);
        return ResponseEntity.ok(roleRequestDto);
    }

    @PostMapping
    public ResponseEntity<RoleRequestDto> save(@RequestBody RoleRequestDto roleRequestDto) {
        RoleRequestDto savedRole = roleHandler.save(roleRequestDto);
        return ResponseEntity.ok(savedRole);
    }
}
