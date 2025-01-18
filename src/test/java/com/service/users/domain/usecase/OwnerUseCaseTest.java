package com.service.users.domain.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.service.users.domain.model.owner.AccountInfo;
import com.service.users.domain.model.owner.ContactInfo;
import com.service.users.domain.model.owner.Owner;
import com.service.users.domain.model.owner.PersonalInfo;
import com.service.users.domain.spi.IOwnerPersistencePort;
import com.service.users.infrastucture.exception.InvalidUserException;

 class OwnerUseCaseTest {

    @Mock
    private IOwnerPersistencePort userPersistencePort;

    @InjectMocks
    private OwnerUseCase ownerUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testSaveOwner_ValidOwner() {
        Owner owner = createValidOwner();
        when(userPersistencePort.saveOwner(any(Owner.class))).thenReturn(owner);

        ownerUseCase.saveOwner(owner);

        verify(userPersistencePort).saveOwner(owner);
    }

    @Test
     void testSaveOwner_InvalidBirthDate() {
        Owner owner = createValidOwner();
        owner.getPersonalInfo().setBirthDate(LocalDate.now());

        assertThrows(InvalidUserException.class, () -> ownerUseCase.saveOwner(owner));
    }

    @Test
     void testSaveOwner_InvalidDocumentId() {
        Owner owner = createValidOwner();
        owner.getContactInfo().setDocumentId(null);

        assertThrows(InvalidUserException.class, () -> ownerUseCase.saveOwner(owner));
    }

    @Test
     void testSaveOwner_InvalidPhone() {
        Owner owner = createValidOwner();
        owner.getContactInfo().setPhone(2133L);

        assertThrows(InvalidUserException.class, () -> ownerUseCase.saveOwner(owner));
    }

    @Test
     void testSaveOwner_InvalidEmail() {
        Owner owner = createValidOwner();
        owner.getContactInfo().setEmail("testgmail.com");

        assertThrows(InvalidUserException.class, () -> ownerUseCase.saveOwner(owner));
    }

    private Owner createValidOwner() {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setDocumentId(123456789L);
        contactInfo.setPhone(3122343231L);
        contactInfo.setEmail("test@example.com");

        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setPassword("password");

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setBirthDate(LocalDate.of(2000, 1, 1));

        Owner owner = new Owner();
        owner.setContactInfo(contactInfo);
        owner.setAccountInfo(accountInfo);
        owner.setPersonalInfo(personalInfo);

        return owner;
    }
}
