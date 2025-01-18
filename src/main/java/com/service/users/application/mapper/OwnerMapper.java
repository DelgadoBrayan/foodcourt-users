package com.service.users.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.service.users.application.dto.owner.OwnerRequestDto;
import com.service.users.application.dto.owner.OwnerResponseDto;
import com.service.users.domain.model.owner.Owner;


@Mapper(componentModel = "spring")
public interface OwnerMapper {

    @Mapping(source = "dto.firstName", target = "personalInfo.firstName")
    @Mapping(source = "dto.lastName", target = "personalInfo.lastName")
    @Mapping(source = "dto.documentId", target = "contactInfo.documentId")
    @Mapping(source = "dto.phone", target = "contactInfo.phone")
    @Mapping(source = "dto.email", target = "contactInfo.email")
    @Mapping(source = "dto.password", target = "accountInfo.password")
    @Mapping(source = "birthDate", target = "personalInfo.birthDate", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "accountInfo.roleId", ignore = true)
    @Mapping(target = "id", ignore = true)
    Owner toEntity(OwnerRequestDto dto);

    @Mapping(source = "owner.id", target = "id")
    @Mapping(source = "owner.personalInfo.firstName", target = "firstName")
    @Mapping(source = "owner.personalInfo.lastName", target = "lastName")
    @Mapping(source = "owner.personalInfo.birthDate", target = "birthDate")
    @Mapping(source = "owner.contactInfo.phone", target = "phone")
    @Mapping(source = "owner.contactInfo.email", target = "email")
    @Mapping(source = "owner.contactInfo.documentId", target = "documentId")
    @Mapping(source = "owner.accountInfo.password", target = "password")
    OwnerRequestDto toDto(Owner owner);

    @Mapping(source = "owner.personalInfo.firstName", target = "firstName")
    @Mapping(source = "owner.personalInfo.lastName", target = "lastName")
    @Mapping(source = "owner.contactInfo.documentId", target = "documentId")
    @Mapping(source = "owner.contactInfo.phone", target = "phone")
    @Mapping(source = "owner.contactInfo.email", target = "email")
    @Mapping(source = "owner.accountInfo.password", target = "password")
    @Mapping(source = "owner.personalInfo.birthDate", target = "birthDate", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "owner.accountInfo.roleId", target = "roleId")
    OwnerResponseDto toResponse(Owner owner);
}
