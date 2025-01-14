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

    public UsersRequest saveEmployee(UsersRequest dto){
        Users employee = usersMapper.toEntity(dto);
        Users saveEmployee = usersServicePort.saveEmployee(employee);
        return usersMapper.toDto(saveEmployee);
    }
}
