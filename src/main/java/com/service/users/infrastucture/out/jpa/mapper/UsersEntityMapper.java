package com.service.users.infrastucture.out.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.service.users.domain.model.users.Users;
import com.service.users.infrastucture.out.jpa.entity.UsersEntity;

@Mapper(componentModel ="spring")
public interface UsersEntityMapper {
   
    @Mapping(source = "employee.contactInfo.documentId", target = "documentId")
    @Mapping(source = "employee.contactInfo.phone", target = "phone")
    @Mapping(source = "employee.contactInfo.email", target = "email")
    UsersEntity toEntity(Users employee);

    @Mapping(source = "entity.documentId", target = "contactInfo.documentId")
    @Mapping(source = "entity.phone", target = "contactInfo.phone")
    @Mapping(source = "entity.email", target = "contactInfo.email")
    Users toDomain(UsersEntity entity);
}
