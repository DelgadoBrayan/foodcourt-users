package com.service.users.application.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RoleRequestDto {
    private Long id;
    private String name;
    private String description;
}
