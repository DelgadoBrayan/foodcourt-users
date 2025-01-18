package com.service.users.application.dto.owner;

import lombok.Data;

@Data
public class OwnerResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Long documentId;
    private Long phone;
    private String birthDate;
    private String email;
    private String password;
    private Long roleId;
}
