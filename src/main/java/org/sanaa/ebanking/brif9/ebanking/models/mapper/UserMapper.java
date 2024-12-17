package org.sanaa.ebanking.brif9.ebanking.models.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.Named;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Request.UserRequestDTO;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Response.UserResponseDTO;
import org.sanaa.ebanking.brif9.ebanking.models.entity.EbankRole;
import org.sanaa.ebanking.brif9.ebanking.models.entity.EbankUser;


@Mapper(componentModel = "spring")
public interface UserMapper {


   @Mapping(source = "role.id", target = "roleId")
   @Mapping(source = "username", target = "userName")
   UserResponseDTO toResponseDTO(EbankUser entity);

   @Mapping(source = "roleId", target = "role", qualifiedByName = "mapRole")
   @Mapping(source = "userName", target = "username")
   EbankUser toEntity(UserRequestDTO requestDTO);

   @Named("mapRole")
   default EbankRole mapRole(Long roleId) {
      if (roleId == null) {
         return null;
      }
      EbankRole role = new EbankRole();
      role.setId(roleId);
      return role;
   }
}

