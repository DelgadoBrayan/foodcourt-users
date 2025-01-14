package com.service.users.domain.usecase;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.service.users.domain.api.IOwnerServicePort;
import com.service.users.domain.model.owner.AccountInfo;
import com.service.users.domain.model.owner.ContactInfo;
import com.service.users.domain.model.owner.Owner;
import com.service.users.domain.model.owner.PersonalInfo;
import com.service.users.domain.spi.IOwnerPersistencePort;
import com.service.users.infrastucture.exception.InvalidUserException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OwnerUseCase implements IOwnerServicePort {
    private final IOwnerPersistencePort userPersistencePort;

    @Override
    public Owner findUserByEmail(String email) {
        return userPersistencePort.findUserByEmail(email);
    }

    @Override
    public Owner findUserById(Long userId) {
        return userPersistencePort.findUserById(userId);
    }

    @Override
    public Owner saveOwner(Owner owner) {
        ContactInfo contactInfo = owner.getContactInfo();
        AccountInfo accountInfo = owner.getAccountInfo();
        PersonalInfo personalInfo = owner.getPersonalInfo();

        validateContactInfo(contactInfo);

        if (personalInfo.getBirthDate() == null || !isOfLegalAge(personalInfo.getBirthDate())) {
            throw new InvalidUserException("El usuario debe ser mayor de edad y la fecha de nacimiento no puede ser nula");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(accountInfo.getPassword());
        accountInfo.setPassword(encodedPassword);
        accountInfo.setRoleId(1L);
        return userPersistencePort.saveOwner(owner);
    }

    private boolean isOfLegalAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears() >= 18;
    }

    private void validateContactInfo(ContactInfo contactInfo) {
        
        if (contactInfo.getDocumentId() == null || !contactInfo.getDocumentId().toString().matches("\\d+")) {
            throw new InvalidUserException("El documento de identidad debe ser numérico y no puede ser nulo.");
        }

        String phoneRegex = "^\\+?(\\d{9,13})$";
        if (!Pattern.compile(phoneRegex).matcher(contactInfo.getPhone().toString()).matches()) {
            throw new InvalidUserException("El número de teléfono es inválido.");
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!Pattern.compile(emailRegex).matcher(contactInfo.getEmail()).matches()) {
            throw new InvalidUserException("El correo electrónico es inválido.");
        }
    }
}