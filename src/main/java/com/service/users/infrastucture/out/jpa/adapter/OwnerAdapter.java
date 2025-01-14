package com.service.users.infrastucture.out.jpa.adapter;


import com.service.users.domain.model.owner.Owner;
import com.service.users.domain.spi.IOwnerPersistencePort;
import com.service.users.infrastucture.out.jpa.entity.OwnerEntity;
import com.service.users.infrastucture.out.jpa.mapper.OwnerEntityMapper;
import com.service.users.infrastucture.out.jpa.repository.OwnerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OwnerAdapter implements IOwnerPersistencePort {
    private final OwnerRepository repository;
    private final OwnerEntityMapper mapper;
    @Override
    public Owner saveOwner(Owner owner) {
        OwnerEntity entity = mapper.toEntity(owner);
        OwnerEntity savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Owner findUserByEmail(String email) {
        OwnerEntity entity = repository.findByEmail(email);
        return mapper.toDomain(entity);
    }
    @Override
    public Owner findUserById(Long userId) {
        OwnerEntity entity = repository.findById(userId).orElse(null);
        return entity != null ? mapper.toDomain(entity) : null;
    }
   
}
