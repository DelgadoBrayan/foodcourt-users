package com.service.users.infrastucture.out.jpa.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.service.users.domain.model.owner.Owner;
import com.service.users.infrastucture.out.jpa.entity.OwnerEntity;
import com.service.users.infrastucture.out.jpa.mapper.OwnerEntityMapper;
import com.service.users.infrastucture.out.jpa.repository.OwnerRepository;

 class OwnerAdapterTest {

    @Mock
    private OwnerRepository repository;

    @Mock
    private OwnerEntityMapper mapper;

    @InjectMocks
    private OwnerAdapter ownerAdapter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testSaveOwner() {
        Owner owner = new Owner();
        OwnerEntity ownerEntity = new OwnerEntity();
        OwnerEntity savedEntity = new OwnerEntity();
        Owner savedOwner = new Owner();

        when(mapper.toEntity(owner)).thenReturn(ownerEntity);
        when(repository.save(ownerEntity)).thenReturn(savedEntity);
        when(mapper.toDomain(savedEntity)).thenReturn(savedOwner);

        Owner result = ownerAdapter.saveOwner(owner);

        assertEquals(savedOwner, result);
        verify(mapper).toEntity(owner);
        verify(repository).save(ownerEntity);
        verify(mapper).toDomain(savedEntity);
    }

    @Test
     void testFindUserByEmail() {
        String email = "test@example.com";
        OwnerEntity ownerEntity = new OwnerEntity();
        Owner owner = new Owner();

        when(repository.findByEmail(email)).thenReturn(ownerEntity);
        when(mapper.toDomain(ownerEntity)).thenReturn(owner);

        Owner result = ownerAdapter.findUserByEmail(email);

        assertEquals(owner, result);
        verify(repository).findByEmail(email);
        verify(mapper).toDomain(ownerEntity);
    }

    @Test
     void testFindUserById() {
        Long userId = 1L;
        OwnerEntity ownerEntity = new OwnerEntity();
        Owner owner = new Owner();

        when(repository.findById(userId)).thenReturn(java.util.Optional.of(ownerEntity));
        when(mapper.toDomain(ownerEntity)).thenReturn(owner);

        Owner result = ownerAdapter.findUserById(userId);

        assertEquals(owner, result);
        verify(repository).findById(userId);
        verify(mapper).toDomain(ownerEntity);
    }

    @Test
     void testFindUserByIdNotFound() {
        Long userId = 1L;

        when(repository.findById(userId)).thenReturn(java.util.Optional.empty());

        Owner result = ownerAdapter.findUserById(userId);

        assertNull(result);
        verify(repository).findById(userId);
        verify(mapper, never()).toDomain(any());
    }
}