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

import com.service.users.application.dto.users.EmployeeRestaurantDto;
import com.service.users.application.handler.EmployeeRestaurantHandler;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employeerestaurant")
@RequiredArgsConstructor
public class EmployeeRestaurantController {

    private final EmployeeRestaurantHandler employeeRestaurantHandler;

    @Operation(summary = "Obtener empleado por ID de restaurante", description = "Obtiene los detalles de un empleado específico de un restaurante.")
    @GetMapping("/{restaurantId}")
    public ResponseEntity<EmployeeRestaurantDto> getEmployeeRestaurantById(@PathVariable Long restaurantId,  @RequestHeader("Authorization") String authorizationHeader) {
        EmployeeRestaurantDto employeeRestaurantDto = employeeRestaurantHandler.findById(restaurantId);
        return ResponseEntity.status(HttpStatus.OK).body(employeeRestaurantDto);
    }

    @Operation(summary = "Registrar nuevo empleado en el restaurante", description = "Crea un nuevo empleado en el restaurante.")
    @PostMapping
    public ResponseEntity<EmployeeRestaurantDto> saveEmployeeRestaurant(@RequestBody EmployeeRestaurantDto employeeRestaurantDto) {
        EmployeeRestaurantDto savedEmployeeRestaurantDto = employeeRestaurantHandler.saveEmployeeRestaurant(employeeRestaurantDto);
        return ResponseEntity.ok(savedEmployeeRestaurantDto);
    }
}
