package org.sanaa.ebanking.brif9.ebanking.models.mapper;

import org.mapstruct.Mapper;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Request.RoleRequestDTO;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Response.RoleResponseDTO;
import org.sanaa.ebanking.brif9.ebanking.models.entity.EbankRole;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleResponseDTO toResponseDTO(EbankRole entity);
    EbankRole toEntity (RoleRequestDTO requestDTO);

}
