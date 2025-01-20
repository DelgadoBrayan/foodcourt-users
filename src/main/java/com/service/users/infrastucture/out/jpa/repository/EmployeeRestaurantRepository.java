package com.service.users.infrastucture.out.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.users.infrastucture.out.jpa.entity.EmployeeRestaurantEntity;

public interface EmployeeRestaurantRepository extends JpaRepository<EmployeeRestaurantEntity, Long>{
    Optional<EmployeeRestaurantEntity> findByEmplooyeId(Long emplooyeId);
}
