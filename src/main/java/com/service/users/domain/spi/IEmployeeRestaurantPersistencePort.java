package com.service.users.domain.spi;

import com.service.users.domain.model.EmployeeRestaurant;

public interface IEmployeeRestaurantPersistencePort {
    EmployeeRestaurant saveEmployeeRestaurant(EmployeeRestaurant employeeRestaurant);
    EmployeeRestaurant findById(Long restaurantId);
}
