package com.service.users.domain.usecase;

import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.service.users.domain.api.IAuthServicePort;
import com.service.users.domain.model.owner.Owner;
import com.service.users.domain.spi.IOwnerPersistencePort;
import com.service.users.infrastucture.exception.InvalidAuthException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationUseCase implements IAuthServicePort {
    private final IOwnerPersistencePort ownerPersistencePort;
    private final byte[] secretKey;
    private static final long EXPIRATION_TIME = 86400000;

    @Override
    public String generateToken(Owner owner) {
        return Jwts.builder()
                .setSubject(owner.getContactInfo().getEmail())
                .claim("role", owner.getAccountInfo().getRoleId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(Keys.hmacShaKeyFor(secretKey), SignatureAlgorithm.HS512)
                .compact();
    }

    @Override
    public String validateCredentials(String email, String password) {
        Owner owner = ownerPersistencePort.findUserByEmail(email);
        if (owner == null || !passwordMatches(password, owner.getAccountInfo().getPassword())) {
            throw new InvalidAuthException("credenciales invalidas");
        }
        return generateToken(owner);
    }

    private boolean passwordMatches(String rawPassword, String storedPassword) {
        boolean passwordCheck = BCrypt.checkpw(rawPassword, storedPassword);
        if(!passwordCheck){
            throw new InvalidAuthException("Contraseña incorrecta");
        }
        return passwordCheck;
    }
}
