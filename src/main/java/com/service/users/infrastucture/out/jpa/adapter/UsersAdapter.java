package com.service.users.infrastucture.out.jpa.adapter;


import com.service.users.domain.model.users.Users;
import com.service.users.domain.spi.IUsersPersistencePort;
import com.service.users.infrastucture.out.jpa.entity.UsersEntity;
import com.service.users.infrastucture.out.jpa.mapper.UsersEntityMapper;
import com.service.users.infrastucture.out.jpa.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsersAdapter implements IUsersPersistencePort {

    private final UserRepository userRepository;
    private final UsersEntityMapper usersEntityMapper;
    @Override
    public Users saveEmployee(Users employee) {

        UsersEntity entity = usersEntityMapper.toEntity(employee);
        UsersEntity saveEmployeeEntity = userRepository.save(entity);
        
        return usersEntityMapper.toDomain(saveEmployeeEntity);
    }
    
}
