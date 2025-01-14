package com.service.users.infrastucture.out.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.service.users.domain.model.owner.Owner;
import com.service.users.infrastucture.out.jpa.entity.OwnerEntity;


@Mapper(componentModel = "spring")
public interface OwnerEntityMapper {
    @Mapping(source = "owner.personalInfo.firstName", target = "firstName")
    @Mapping(source = "owner.personalInfo.lastName", target = "lastName")
    @Mapping(source = "owner.personalInfo.birthDate", target = "birthDate")
    @Mapping(source = "owner.contactInfo.documentId", target = "documentId")
    @Mapping(source = "owner.contactInfo.phone", target = "phone")
    @Mapping(source = "owner.contactInfo.email", target = "email")
    @Mapping(source = "owner.accountInfo.password", target = "password")
    @Mapping(source = "owner.accountInfo.roleId", target = "roleId")
    OwnerEntity toEntity(Owner owner);

    @Mapping(source = "entity.firstName", target = "personalInfo.firstName")
    @Mapping(source = "entity.lastName", target = "personalInfo.lastName")
    @Mapping(source = "entity.birthDate", target = "personalInfo.birthDate")
    @Mapping(source = "entity.documentId", target = "contactInfo.documentId")
    @Mapping(source = "entity.phone", target = "contactInfo.phone")
    @Mapping(source = "entity.email", target = "contactInfo.email")
    @Mapping(source = "entity.password", target = "accountInfo.password")
    @Mapping(source = "entity.roleId", target = "accountInfo.roleId")
    Owner toDomain(OwnerEntity entity);
}