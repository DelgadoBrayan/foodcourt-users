package com.service.users.infrastucture.input.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.users.application.dto.users.UsersRequest;
import com.service.users.application.handler.UsersHandler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/owner/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersHandler usersHandler;

      @PostMapping("/employee")
    public ResponseEntity<Void> createEmployee(@Valid @RequestBody UsersRequest employeeRequest) {
        usersHandler.saveEmployee(employeeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/client")
    public ResponseEntity<Void> createClient(@Valid @RequestBody UsersRequest clientRequest) {
        usersHandler.saveClient(clientRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
