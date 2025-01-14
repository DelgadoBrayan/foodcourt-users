package com.service.users.infrastucture.out.jpa.adapter;


import com.service.users.domain.model.Role;
import com.service.users.domain.spi.IRolePersistencePort;
import com.service.users.infrastucture.out.jpa.entity.RoleEntity;
import com.service.users.infrastucture.out.jpa.mapper.RoleEntityMapper;
import com.service.users.infrastucture.out.jpa.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoleAdapter implements IRolePersistencePort {
    private final RoleRepository repository;
    private final RoleEntityMapper mapper;

    @Override
    public Role findByName(String name) {
        RoleEntity roleEntity = repository.findByName(name);
        return mapper.toDomain(roleEntity);
    }

    @Override
    public Role save(Role role) {
        RoleEntity roleEntity = mapper.toEntity(role);
        RoleEntity savedEntity = repository.save(roleEntity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Role findById(Long roleId) {
        RoleEntity roleEntity = repository.findById(roleId).orElse(null);
        return roleEntity != null ? mapper.toDomain(roleEntity) : null;
    }
}