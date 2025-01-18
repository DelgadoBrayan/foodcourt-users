package com.service.users.domain.api;

import com.service.users.domain.model.EmployeeRestaurant;

public interface IEmployeeResaurantServicePort {
    EmployeeRestaurant saveEmployeeRestaurant(EmployeeRestaurant employeeRestaurant);
    EmployeeRestaurant findById(Long restaurantId);
}
