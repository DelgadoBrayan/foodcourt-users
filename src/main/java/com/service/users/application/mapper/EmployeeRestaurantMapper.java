package com.service.users.application.mapper;

import org.mapstruct.Mapper;

import com.service.users.application.dto.users.EmployeeRestaurantDto;
import com.service.users.domain.model.EmployeeRestaurant;

@Mapper(componentModel = "spring")
public interface EmployeeRestaurantMapper {

    EmployeeRestaurant toEntity(EmployeeRestaurantDto employeeRestaurantDto);
    EmployeeRestaurantDto toDto(EmployeeRestaurant employeeRestaurant);

}
