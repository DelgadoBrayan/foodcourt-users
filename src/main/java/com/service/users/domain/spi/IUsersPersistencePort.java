package com.service.users.domain.spi;

import com.service.users.domain.model.users.Users;

public interface IUsersPersistencePort {

    Users saveUser(Users users);


    Users findById(Long idUser);
}
