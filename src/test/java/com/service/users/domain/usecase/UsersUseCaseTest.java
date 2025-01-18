package com.service.users.domain.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;

import com.service.users.domain.model.users.ContactInfo;
import com.service.users.domain.model.users.Users;
import com.service.users.domain.spi.IEmployeeRestaurantPersistencePort;
import com.service.users.domain.spi.IOwnerPersistencePort;
import com.service.users.domain.spi.IUsersPersistencePort;
import com.service.users.infrastucture.exception.InvalidUserException;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@ExtendWith(MockitoExtension.class)
class UsersUseCaseTest {

    @Mock
    private IUsersPersistencePort usersPersistencePort;

    @Mock
    private IOwnerPersistencePort ownerPersistencePort;

    @Mock
    private IEmployeeRestaurantPersistencePort employeeRestaurantPersistencePort;

    @Mock
    private WebClient restaurantWebClient;

    @Mock
    private RequestHeadersUriSpec<?> requestHeadersUriSpec;

    @Mock
    private WebClient.RequestHeadersSpec<?> requestHeadersSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    @InjectMocks
    private UsersUseCase usersUseCase;

    private final byte[] secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded();

    @BeforeEach
    void setup() {
        usersUseCase = new UsersUseCase(usersPersistencePort, ownerPersistencePort, employeeRestaurantPersistencePort, restaurantWebClient, secretKey);
    }
    

    @Test
    void saveClient_validInputs_success() {
        ContactInfo contactInfo = new ContactInfo("105431232","3122321212", "example@gmail.com");
        Users client = new Users();
        client.setId(1L);
        client.setFistName("test");
        client.setLastName("test");
        client.setIdRol(2L);
        client.setPassword("password");
        client.setContactInfo(contactInfo);
       
        client.setPassword("password123");

        Users savedClient = new Users();
        savedClient.setId(1L);

        when(usersPersistencePort.saveUser(any(Users.class))).thenReturn(savedClient);

        // Act
        Users result = usersUseCase.saveClient(client);

        // Assert
        assertNotNull(result);
        assertEquals(savedClient.getId(), result.getId());
        verify(usersPersistencePort).saveUser(any(Users.class));
    }

    @Test
    void saveClient_invalidFields_throwsException() {
        // Arrange
        Users client = new Users(); // Missing fields

        // Act & Assert
        InvalidUserException exception = assertThrows(InvalidUserException.class, () ->
            usersUseCase.saveClient(client)
        );

        assertTrue(exception.getMessage().contains("El apellido del usuario no debe estar vacío o nulo"));
        verifyNoInteractions(usersPersistencePort);
    }


}
