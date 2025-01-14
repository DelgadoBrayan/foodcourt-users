package com.service.users.domain.usecase;

import org.springframework.stereotype.Service;

import com.service.users.domain.api.IRoleServicePort;
import com.service.users.domain.model.Role;
import com.service.users.domain.spi.IRolePersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleUseCase implements IRoleServicePort {
    private final IRolePersistencePort rolePersistencePort;

    @Override
    public Role findByName(String name) {
        return rolePersistencePort.findByName(name);

    }
    @Override
    public Role save(Role role) {
        return rolePersistencePort.save(role);
    }

    @Override
    public Role findById(Long id) {
        return rolePersistencePort.findById(id);
    }
}
