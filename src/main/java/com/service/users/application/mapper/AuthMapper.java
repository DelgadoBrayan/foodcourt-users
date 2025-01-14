package com.service.users.application.mapper;

import org.mapstruct.Mapper;


import com.service.users.application.dto.auth.AuthRequestDto;
import com.service.users.domain.model.AuthLogin;


@Mapper(componentModel = "spring")
public interface AuthMapper {
    AuthLogin toEntity(AuthRequestDto dto);

    AuthRequestDto toDto(AuthLogin auth);
}
