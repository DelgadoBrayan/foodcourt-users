package com.service.users.infrastucture.out.jpa.mapper;

import org.mapstruct.Mapper;

import com.service.users.domain.model.EmployeeRestaurant;
import com.service.users.infrastucture.out.jpa.entity.EmployeeRestaurantEntity;

@Mapper(componentModel = "spring")
public interface EmpRestEntityMapper {
    EmployeeRestaurantEntity toEntity(EmployeeRestaurant employeeRestaurantDto);
    EmployeeRestaurant toDto(EmployeeRestaurantEntity employeeRestaurantEntity);
}
