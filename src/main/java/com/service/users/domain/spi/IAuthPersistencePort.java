package com.service.users.domain.spi;

import com.service.users.domain.model.owner.Owner;

public interface IAuthPersistencePort {
    String validateCredentials(String email, String password);
    String generateToken(Owner owner);
}
