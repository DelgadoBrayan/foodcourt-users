package com.service.users.infrastucture.out.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.users.infrastucture.out.jpa.entity.RoleEntity;



public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByName(String name);
}