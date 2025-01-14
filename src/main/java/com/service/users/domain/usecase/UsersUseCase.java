package com.service.users.domain.usecase;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.service.users.domain.api.IUsersServicePort;
import com.service.users.domain.model.users.ContactInfo;
import com.service.users.domain.model.users.Users;
import com.service.users.domain.spi.IUsersPersistencePort;
import com.service.users.infrastucture.exception.InvalidUserException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersUseCase implements IUsersServicePort{

    private final IUsersPersistencePort usersPersistencePort;

 @Override
public Users saveEmployee(Users employee) {

    validateUserFields(employee);

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(employee.getPassword());
    employee.setPassword(encodedPassword);
    employee.setIdRol(2L);
    
    return usersPersistencePort.saveUser(employee);
}


@Override
public Users saveClient(Users client) {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(client.getPassword());
    client.setPassword(encodedPassword);
    client.setIdRol(3L);
    
    return usersPersistencePort.saveUser(client);
}

private void validateUserFields(Users employee) {
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
