package com.service.users.infrastucture.out.jpa.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.service.users.domain.model.users.Users;
import com.service.users.infrastucture.out.jpa.entity.UsersEntity;
import com.service.users.infrastucture.out.jpa.mapper.UsersEntityMapper;
import com.service.users.infrastucture.out.jpa.repository.UserRepository;

 class UsersAdapterTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UsersEntityMapper usersEntityMapper;

    @InjectMocks
    private UsersAdapter usersAdapter;

    private Users user;
    private UsersEntity userEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new Users();
        userEntity = new UsersEntity();
    }

    @Test
     void testSaveUser() {
        when(usersEntityMapper.toEntity(any(Users.class))).thenReturn(userEntity);
        when(userRepository.save(any(UsersEntity.class))).thenReturn(userEntity);
        when(usersEntityMapper.toDomain(any(UsersEntity.class))).thenReturn(user);

        Users result = usersAdapter.saveUser(user);

        assertEquals(user, result);
    }
}
