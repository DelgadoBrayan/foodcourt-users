package com.service.users.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.service.users.application.dto.RoleRequestDto;
import com.service.users.domain.model.Role;

@Mapper(componentModel ="spring")
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role toEntity(RoleRequestDto dto);

    RoleRequestDto toDto(Role role);
    
}
