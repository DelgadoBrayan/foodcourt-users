package com.service.users.application.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AuthResponseDto {
    private String token;
}
