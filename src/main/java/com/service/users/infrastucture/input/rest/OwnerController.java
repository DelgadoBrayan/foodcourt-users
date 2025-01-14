package com.service.users.infrastucture.input.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.users.application.dto.owner.OwnerRequestDto;
import com.service.users.application.handler.OwnerHandler;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/owner")
@RequiredArgsConstructor
public class OwnerController {
   
    private final OwnerHandler ownerHandler;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody OwnerRequestDto registerRequestDto) {
        ownerHandler.saveUser(registerRequestDto);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

}