package com.service.users.domain.usecase;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.service.users.domain.api.IUsersServicePort;
import com.service.users.domain.model.EmployeeRestaurant;
import com.service.users.domain.model.Restaurant;
import com.service.users.domain.model.owner.Owner;
import com.service.users.domain.model.users.ContactInfo;
import com.service.users.domain.model.users.Users;
import com.service.users.domain.spi.IEmployeeRestaurantPersistencePort;
import com.service.users.domain.spi.IOwnerPersistencePort;
import com.service.users.domain.spi.IUsersPersistencePort;
import com.service.users.infrastucture.exception.InvalidUserException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsersUseCase implements IUsersServicePort{

    private final IUsersPersistencePort usersPersistencePort;
    private final IOwnerPersistencePort ownerPersistencePort;
    private final IEmployeeRestaurantPersistencePort employeeRestaurantPersistencePort;
    private final WebClient restaurantWebClient;
    private final byte[] secretKey;

 @Override

public void saveEmployee(Users employee, String token, Long restaurantId) {
    validateEmployeeFields(employee);
    Claims claims = Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .getBody();
    String email = claims.getSubject(); 
    Long roleId = claims.get("role", Long.class);
    if(1 !=roleId){
        throw new InvalidUserException("No puedes generar esta accion por tu rol");
    }
    Owner owner = ownerPersistencePort.findUserByEmail(email);
    Restaurant restaurantResponse =  restaurantWebClient.get()
    .uri("/{restaurantId}", restaurantId)
    .retrieve()
    .onStatus(status -> status == HttpStatus.BAD_REQUEST, clientResponse -> Mono.error(new InvalidUserException("Error al obtener el restaurante")))
    .bodyToMono(Restaurant.class)
    .block();
    if(!restaurantResponse.getOwnerId().equals(owner.getId())){
        throw new InvalidUserException("No eres el propetario de este restaurante, no puedes realizar esta accion");
    }

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(employee.getPassword());
    employee.setPassword(encodedPassword);
    employee.setIdRol(2L);

    Users employeeSave = usersPersistencePort.saveEmployee(employee);
    EmployeeRestaurant employeeRestaurant = new EmployeeRestaurant(restaurantResponse.getId(), employeeSave.getId());
    employeeRestaurantPersistencePort.saveEmployeeRestaurant(employeeRestaurant);
  
}


@Override
public Users saveClient(Users client) {
    validateUserFields(client)
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(client.getPassword());
    client.setPassword(encodedPassword);
    client.setIdRol(3L);
    
    return usersPersistencePort.saveUser(client);
}

@Override
public Users findById(Long userId) {
    return usersPersistencePort.findById(userId);
}

private void validateUserFields(Users user) {
    ContactInfo contactInfo = employee.getContactInfo();
    if (isNullOrEmpty(employee.getLastName())) {
        throw new InvalidUserException("El apellido del usuario no debe estar vacío o nulo");
    }
    if (isNullOrEmpty(employee.getLastName())) {
        throw new InvalidUserException("El nombre del usuario no debe estar vacío o nulo");
    }
    if (isNullOrEmpty(contactInfo.getDocumentId())) {
        throw new InvalidUserException("El documento de identidad no debe estar vacío o nulo");
    }
    if (isNullOrEmpty(contactInfo.getPhone()) || !contactInfo.getPhone().matches("\\+?\\d{1,13}")) {
        throw new InvalidUserException("El celular debe ser numérico, con un máximo de 13 caracteres, y puede incluir '+'");
    }
    if (isNullOrEmpty(contactInfo.getEmail()) || !contactInfo.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
        throw new InvalidUserException("El correo debe tener un formato válido");
    }
    if (isNullOrEmpty(employee.getPassword())) {
        throw new InvalidUserException("La contraseña no debe estar vacía o nula");
    }
}

private boolean isNullOrEmpty(String value) {
    return value == null || value.trim().isEmpty();
}

  
}
