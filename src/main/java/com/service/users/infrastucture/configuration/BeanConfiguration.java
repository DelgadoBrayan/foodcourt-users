package com.service.users.infrastucture.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.domain.api.IOwnerServicePort;
import com.service.users.domain.api.IRoleServicePort;
import com.service.users.domain.api.IUsersServicePort;
import com.service.users.domain.spi.IOwnerPersistencePort;
import com.service.users.domain.spi.IRolePersistencePort;
import com.service.users.domain.spi.IUsersPersistencePort;
import com.service.users.domain.usecase.OwnerUseCase;
import com.service.users.domain.usecase.RoleUseCase;
import com.service.users.domain.usecase.UsersUseCase;
import com.service.users.infrastucture.out.jpa.adapter.OwnerAdapter;
import com.service.users.infrastucture.out.jpa.adapter.RoleAdapter;
import com.service.users.infrastucture.out.jpa.adapter.UsersAdapter;
import com.service.users.infrastucture.out.jpa.mapper.OwnerEntityMapper;
import com.service.users.infrastucture.out.jpa.mapper.RoleEntityMapper;
import com.service.users.infrastucture.out.jpa.mapper.UsersEntityMapper;
import com.service.users.infrastucture.out.jpa.repository.OwnerRepository;
import com.service.users.infrastucture.out.jpa.repository.RoleRepository;
import com.service.users.infrastucture.out.jpa.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final OwnerRepository ownerRepository;
    private final OwnerEntityMapper ownerEntityMapper;
    private final RoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;
    private final UserRepository userRepository;
    private final UsersEntityMapper usersEntityMapper;

    @Bean
    IOwnerPersistencePort ownerPersistencePort(){
        return new OwnerAdapter(ownerRepository, ownerEntityMapper);
    }

    @Bean
    IOwnerServicePort ownerServicePort(){
        return new OwnerUseCase(ownerPersistencePort());
    }

      @Bean
    IRolePersistencePort rolePersistencePort() {
        return new RoleAdapter(roleRepository, roleEntityMapper);
    }

    @Bean
    IRoleServicePort roleServicePort() {
        return new RoleUseCase(rolePersistencePort());
    }

    @Bean
    IUsersPersistencePort usersPersistencePort() {
        return new UsersAdapter(userRepository, usersEntityMapper);
    }

    @Bean
    IUsersServicePort usersServicePort() {
        return new UsersUseCase(usersPersistencePort());
    }

}
