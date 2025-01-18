package com.service.users.application.handler;

import org.springframework.stereotype.Service;

import com.service.users.application.dto.users.EmployeeRestaurantDto;
import com.service.users.application.mapper.EmployeeRestaurantMapper;
import com.service.users.domain.api.IEmployeeResaurantServicePort;
import com.service.users.domain.model.EmployeeRestaurant;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeRestaurantHandler {
    private final IEmployeeResaurantServicePort employeeResaurantServicePort;
    private final EmployeeRestaurantMapper employeeRestaurantMapper;


    public EmployeeRestaurantDto saveEmployeeRestaurant(EmployeeRestaurantDto dto) {
        EmployeeRestaurant employeeRestaurant = employeeRestaurantMapper.toEntity(dto);
        EmployeeRestaurant employeeRestaurantSave = employeeResaurantServicePort.saveEmployeeRestaurant(employeeRestaurant);
        return employeeRestaurantMapper.toDto(employeeRestaurantSave);
    }

        public EmployeeRestaurantDto findById(Long userId) {
        EmployeeRestaurant employeeRestaurant = employeeResaurantServicePort.findById(userId);
        return employeeRestaurantMapper.toDto(employeeRestaurant);
    }

}
