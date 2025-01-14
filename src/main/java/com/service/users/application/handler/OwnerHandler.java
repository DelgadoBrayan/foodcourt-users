package com.service.users.application.handler;

import org.springframework.stereotype.Service;

import com.service.users.application.dto.owner.OwnerRequestDto;
import com.service.users.application.mapper.OwnerMapper;
import com.service.users.domain.api.IOwnerServicePort;
import com.service.users.domain.model.owner.Owner;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OwnerHandler {
    private final IOwnerServicePort ownerServicePort;
    private final OwnerMapper ownerMapper;

    public OwnerRequestDto saveUser(OwnerRequestDto dto) {
        Owner owner = ownerMapper.toEntity(dto);
        Owner savedOwner = ownerServicePort.saveOwner(owner);
        return ownerMapper.toDto(savedOwner);
    }

    public OwnerRequestDto findUserByEmail(String email) {
        Owner owner = ownerServicePort.findUserByEmail(email);
        return ownerMapper.toDto(owner);
    }

    public OwnerRequestDto findUserById(Long userId) {
        Owner owner = ownerServicePort.findUserById(userId);
        return ownerMapper.toDto(owner);
    }

}
