package com.service.users.domain.api;

import com.service.users.domain.model.users.Users;

public interface IUsersServicePort {
    Users saveEmployee(Users employee);
    Users saveClient(Users client);
    Users findById(Long userId);
}
