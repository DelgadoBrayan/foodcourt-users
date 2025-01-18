package com.service.users.domain.usecase;

import org.springframework.stereotype.Service;

import com.service.users.domain.api.IEmployeeResaurantServicePort;
import com.service.users.domain.model.EmployeeRestaurant;
import com.service.users.domain.spi.IEmployeeRestaurantPersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeRestaurantUseCase implements IEmployeeResaurantServicePort{

    private final IEmployeeRestaurantPersistencePort employeeRestaurantPersistencePort;
    @Override
    public EmployeeRestaurant saveEmployeeRestaurant(EmployeeRestaurant employeeRestaurant) {
        return employeeRestaurantPersistencePort.saveEmployeeRestaurant(employeeRestaurant);
    }

    @Override
    public EmployeeRestaurant findById(Long restaurantId) {
      return employeeRestaurantPersistencePort.findById(restaurantId);
    }
    
}
