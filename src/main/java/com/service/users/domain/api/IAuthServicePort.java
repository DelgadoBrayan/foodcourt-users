package com.service.users.domain.api;

import com.service.users.domain.model.owner.Owner;

public interface IAuthServicePort {
    String validateCredentials(String email, String password);
    String generateToken(Owner owner);
}
