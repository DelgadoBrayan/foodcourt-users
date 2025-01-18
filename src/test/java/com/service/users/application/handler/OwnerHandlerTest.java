package com.service.users.application.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.service.users.application.dto.owner.OwnerRequestDto;
import com.service.users.application.dto.owner.OwnerResponseDto;
import com.service.users.application.mapper.OwnerMapper;
import com.service.users.domain.api.IOwnerServicePort;
import com.service.users.domain.model.owner.Owner;

class OwnerHandlerTest {

    @Mock
    private IOwnerServicePort ownerServicePort;

    @Mock
    private OwnerMapper ownerMapper;

    @InjectMocks
    private OwnerHandler ownerHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUser_ValidOwner() {
        OwnerRequestDto dto = new OwnerRequestDto();
        Owner owner = new Owner();
        Owner savedOwner = new Owner();
        OwnerRequestDto savedDto = new OwnerRequestDto();

        when(ownerMapper.toEntity(dto)).thenReturn(owner);
        when(ownerServicePort.saveOwner(owner)).thenReturn(savedOwner);
        when(ownerMapper.toDto(savedOwner)).thenReturn(savedDto);

        OwnerRequestDto result = ownerHandler.saveUser(dto);

        assertEquals(savedDto, result);
        verify(ownerMapper).toEntity(dto);
        verify(ownerServicePort).saveOwner(owner);
        verify(ownerMapper).toDto(savedOwner);
    }

    @Test
    void testFindUserByEmail() {
        String email = "test@example.com";
        Owner owner = new Owner();
        OwnerRequestDto dto = new OwnerRequestDto();

        when(ownerServicePort.findUserByEmail(email)).thenReturn(owner);
        when(ownerMapper.toDto(owner)).thenReturn(dto);

        OwnerRequestDto result = ownerHandler.findUserByEmail(email);

        assertEquals(dto, result);
        verify(ownerServicePort).findUserByEmail(email);
        verify(ownerMapper).toDto(owner);
    }

    @Test
    void testFindUserById() {
        Long userId = 1L;
        Owner owner = new Owner();
        OwnerResponseDto dto = new OwnerResponseDto();

        when(ownerServicePort.findUserById(userId)).thenReturn(owner);
        when(ownerMapper.toResponse(owner)).thenReturn(dto);

        OwnerResponseDto result = ownerHandler.findUserById(userId);

        assertEquals(dto, result);
        verify(ownerServicePort).findUserById(userId);
        verify(ownerMapper).toResponse(owner);
    }
}
