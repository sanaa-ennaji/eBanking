package org.sanaa.ebanking.brif9.ebanking.models.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Request.UserRequestDTO;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Response.UserResponseDTO;
import org.sanaa.ebanking.brif9.ebanking.models.entity.EbankUser;


@Mapper(componentModel = "spring")
public interface UserMapper {
   @Mapping(source = "roleId", target = "role.id")
   UserResponseDTO toResponseDTO(EbankUser entity);
   @Mapping(source = "role.name", target = "role")
   EbankUser toEntity(UserRequestDTO requestDTO);
}

