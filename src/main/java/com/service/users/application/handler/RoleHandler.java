package com.service.users.application.handler;

import org.springframework.stereotype.Service;

import com.service.users.application.dto.RoleRequestDto;
import com.service.users.application.mapper.RoleMapper;
import com.service.users.domain.api.IRoleServicePort;
import com.service.users.domain.model.Role;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleHandler {
    private final IRoleServicePort roleServicePort;
    private static final RoleMapper roleMapper = RoleMapper.INSTANCE;

    public RoleRequestDto findByName(String name) {
        Role role = roleServicePort.findByName(name);
        return roleMapper.toDto(role);
    }

    public RoleRequestDto save(RoleRequestDto roleRequestDto) {
        Role role = roleMapper.toEntity(roleRequestDto);
        Role savedRole = roleServicePort.save(role);
        return roleMapper.toDto(savedRole);
    }
}
