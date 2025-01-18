package com.service.users.application.handler;

import org.springframework.stereotype.Service;

import com.service.users.application.dto.users.UsersRequest;
import com.service.users.application.mapper.UsersMapper;
import com.service.users.domain.api.IUsersServicePort;
import com.service.users.domain.model.users.Users;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UsersHandler {
    private final IUsersServicePort usersServicePort;
    private final UsersMapper usersMapper;

    public void saveEmployee(UsersRequest dto, String token, Long restaurantId){
        Users employee = usersMapper.toEntity(dto);
        usersServicePort.saveEmployee(employee, token, restaurantId);
     
    }
}
