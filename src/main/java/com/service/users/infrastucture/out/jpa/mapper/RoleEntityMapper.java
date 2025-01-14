package com.service.users.infrastucture.out.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.service.users.domain.model.Role;
import com.service.users.infrastucture.out.jpa.entity.RoleEntity;

@Mapper(componentModel = "spring")
public interface RoleEntityMapper {
    RoleEntityMapper INSTANCE = Mappers.getMapper(RoleEntityMapper.class);

    RoleEntity toEntity(Role role);

    Role toDomain(RoleEntity entity);
}
