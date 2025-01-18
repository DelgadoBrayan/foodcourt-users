package com.service.users.infrastucture.out.jpa.adapter;

import com.service.users.domain.model.EmployeeRestaurant;
import com.service.users.domain.spi.IEmployeeRestaurantPersistencePort;
import com.service.users.infrastucture.out.jpa.entity.EmployeeRestaurantEntity;
import com.service.users.infrastucture.out.jpa.mapper.EmpRestEntityMapper;
import com.service.users.infrastucture.out.jpa.repository.EmployeeRestaurantRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class EmployeeRestaurantAdapter implements IEmployeeRestaurantPersistencePort {

    private final EmployeeRestaurantRepository employeeRestaurantRepository;
    private final EmpRestEntityMapper entityMapper;
    @Override
    public EmployeeRestaurant saveEmployeeRestaurant(EmployeeRestaurant employeeRestaurant) {
        EmployeeRestaurantEntity entity = entityMapper.toEntity(employeeRestaurant);
        EmployeeRestaurantEntity savedEntity = employeeRestaurantRepository.save(entity);
        return entityMapper.toDto(savedEntity);
    }

    @Override
    public EmployeeRestaurant findById(Long restaurantId) {
        EmployeeRestaurantEntity entity = employeeRestaurantRepository.findByRestaurantId(restaurantId).orElse(null);
        return entity != null ? entityMapper.toDto(entity) : null;
    }
    
}
