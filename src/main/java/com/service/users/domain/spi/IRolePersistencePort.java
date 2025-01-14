package com.service.users.domain.spi;

import com.service.users.domain.model.Role;

public interface IRolePersistencePort {
    Role findByName(String name);
    Role save(Role role);
    Role findById(Long roleId);
}
