package com.service.users.domain.api;

import com.service.users.domain.model.Role;

public interface IRoleServicePort {
    Role findByName(String name);
    Role save(Role role);
    Role findById(Long id);
}
