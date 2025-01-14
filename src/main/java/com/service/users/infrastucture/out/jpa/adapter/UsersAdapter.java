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
    public Users saveUser(Users user) {
        
        UsersEntity entity = usersEntityMapper.toEntity(user);
        UsersEntity saveUserEntity = userRepository.save(entity);
        
        return usersEntityMapper.toDomain(saveUserEntity);
    }
    
}
