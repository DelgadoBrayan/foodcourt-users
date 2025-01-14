package com.service.users.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.service.users.application.dto.users.UsersRequest;
import com.service.users.domain.model.users.Users;

@Mapper(componentModel ="spring")
public interface UsersMapper {

    @Mapping(source = "dto.documentId", target = "contactInfo.documentId")
    @Mapping(source = "dto.phone", target = "contactInfo.phone")
    @Mapping(source = "dto.email", target = "contactInfo.email")
    @Mapping(target  = "idRol",ignore= true)
    Users toEntity(UsersRequest dto);

    @Mapping(source = "users.contactInfo.documentId", target = "documentId")
    @Mapping(source = "users.contactInfo.phone", target = "phone")
    @Mapping(source = "users.contactInfo.email", target = "email")
    UsersRequest toDto(Users users);
}
