package com.service.users.application.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.service.users.application.dto.users.UsersRequest;
import com.service.users.application.mapper.UsersMapper;
import com.service.users.domain.api.IUsersServicePort;
import com.service.users.domain.model.users.Users;

 class UsersHandlerTest {

    @Mock
    private IUsersServicePort usersServicePort;

    @Mock
    private UsersMapper usersMapper;

    @InjectMocks
    private UsersHandler usersHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveEmployee() {
        UsersRequest dto = new UsersRequest();
        Users employee = new Users();
        String token = "token";
        Long restaurantId = 1L;

        when(usersMapper.toEntity(dto)).thenReturn(employee);

        usersHandler.saveEmployee(dto, token, restaurantId);

        verify(usersMapper).toEntity(dto);
        verify(usersServicePort).saveEmployee(employee, token, restaurantId);
    }

    @Test
    void testSaveClient() {
        UsersRequest dto = new UsersRequest();
        Users client = new Users();
        Users savedClient = new Users();

        when(usersMapper.toEntity(dto)).thenReturn(client);
        when(usersServicePort.saveClient(client)).thenReturn(savedClient);
        when(usersMapper.toDto(savedClient)).thenReturn(dto);

        UsersRequest result = usersHandler.saveClient(dto);

        assertEquals(dto, result);
        verify(usersMapper).toEntity(dto);
        verify(usersServicePort).saveClient(client);
        verify(usersMapper).toDto(savedClient);
    }

    @Test
    void testFindUserById() {
        Long userId = 1L;
        Users user = new Users();
        UsersRequest dto = new UsersRequest();

        when(usersServicePort.findById(userId)).thenReturn(user);
        when(usersMapper.toDto(user)).thenReturn(dto);

        UsersRequest result = usersHandler.findUserById(userId);

        assertEquals(dto, result);
        verify(usersServicePort).findById(userId);
        verify(usersMapper).toDto(user);
    }
}