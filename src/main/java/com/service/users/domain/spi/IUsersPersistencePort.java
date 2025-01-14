package com.service.users.domain.spi;

import com.service.users.domain.model.users.Users;

public interface IUsersPersistencePort {

    Users saveEmployee(Users users);
}
