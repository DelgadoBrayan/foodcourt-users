package com.service.users.infrastucture.out.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.users.infrastucture.out.jpa.entity.OwnerEntity;

public interface OwnerRepository extends JpaRepository<OwnerEntity, Long>{
    
}
