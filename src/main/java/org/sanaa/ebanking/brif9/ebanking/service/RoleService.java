package org.sanaa.ebanking.brif9.ebanking.service;

import org.sanaa.ebanking.brif9.ebanking.models.dto.Request.RoleRequestDTO;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Response.RoleResponseDTO;
import org.sanaa.ebanking.brif9.ebanking.models.entity.EbankRole;
import org.sanaa.ebanking.brif9.ebanking.models.mapper.RoleMapper;
import org.sanaa.ebanking.brif9.ebanking.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleService(RoleRepository roleRepository, RoleMapper releMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = releMapper;
    }

    public RoleResponseDTO create (RoleRequestDTO roleRequestDTO){
        EbankRole role  = roleMapper.toEntity(roleRequestDTO);
        EbankRole savedRole = roleRepository.save(role);
        return roleMapper.toResponseDTO(savedRole);
    }
}
