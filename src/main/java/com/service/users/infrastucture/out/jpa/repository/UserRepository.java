package com.service.users.infrastucture.out.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.users.infrastucture.out.jpa.entity.UsersEntity;


public interface UserRepository extends JpaRepository<UsersEntity, Long>{
    
}
