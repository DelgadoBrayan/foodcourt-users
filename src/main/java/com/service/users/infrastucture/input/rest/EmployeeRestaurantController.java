package com.service.users.infrastucture.input.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.users.application.dto.users.EmployeeRestaurantDto;
import com.service.users.application.handler.EmployeeRestaurantHandler;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employeerestaurant")
@RequiredArgsConstructor
public class EmployeeRestaurantController {

    private final EmployeeRestaurantHandler employeeRestaurantHandler;

    @GetMapping("/{restaurantId}")
    public ResponseEntity<EmployeeRestaurantDto> getEmployeeRestaurantById(@PathVariable Long restaurantId) {
        EmployeeRestaurantDto employeeRestaurantDto = employeeRestaurantHandler.findById(restaurantId);
        return ResponseEntity.ok(employeeRestaurantDto);
    }

    @PostMapping
    public ResponseEntity<EmployeeRestaurantDto> saveEmployeeRestaurant(@RequestBody EmployeeRestaurantDto employeeRestaurantDto) {
        EmployeeRestaurantDto savedEmployeeRestaurantDto = employeeRestaurantHandler.saveEmployeeRestaurant(employeeRestaurantDto);
        return ResponseEntity.ok(savedEmployeeRestaurantDto);
    }
}
