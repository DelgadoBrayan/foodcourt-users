package com.service.users.application.handler;

import org.springframework.stereotype.Service;

import com.service.users.application.dto.auth.AuthRequestDto;
import com.service.users.application.dto.auth.AuthResponseDto;
import com.service.users.application.dto.owner.OwnerRequestDto;
import com.service.users.application.mapper.AuthMapper;
import com.service.users.application.mapper.OwnerMapper;
import com.service.users.domain.api.IAuthServicePort;
import com.service.users.domain.model.AuthLogin;
import com.service.users.domain.model.owner.Owner;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationHandler {
    private final IAuthServicePort authServicePort;
    private final AuthMapper authMapper;
    private final OwnerMapper ownerMapper;

    public AuthResponseDto login(AuthRequestDto authRequestDto) {
        AuthLogin auth = authMapper.toEntity(authRequestDto);
        String token = authServicePort.validateCredentials(auth.getEmail(), auth.getPassword());
        return new AuthResponseDto(token);
    }

    public AuthResponseDto generateToken(OwnerRequestDto userRequestDto) {
        Owner user = ownerMapper.toEntity(userRequestDto);
        String token = authServicePort.generateToken(user);
        return new AuthResponseDto(token);
    }
}