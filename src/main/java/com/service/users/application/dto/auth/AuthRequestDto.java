package com.service.users.application.dto.auth;


import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class AuthRequestDto {
    private String email;
    private String password;
}
