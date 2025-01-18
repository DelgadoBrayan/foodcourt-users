package com.service.users.domain.api;

import com.service.users.domain.model.users.Users;

public interface IUsersServicePort {

    void saveEmployee(Users users, String token, Long restaurantId);
    Users saveClient(Users client);
    Users findById(Long userId);
}
