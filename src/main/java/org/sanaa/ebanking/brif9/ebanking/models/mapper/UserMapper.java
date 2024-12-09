package org.sanaa.ebanking.brif9.ebanking.models.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Request.UserRequestDTO;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Response.UserResponseDTO;
import org.sanaa.ebanking.brif9.ebanking.models.entity.EbankUser;


@Mapper(componentModel = "spring")
public interface UserMapper {
   UserResponseDTO toResponseDTO(EbankUser entity);
   EbankUser toEntity(UserRequestDTO requestDTO);
}

