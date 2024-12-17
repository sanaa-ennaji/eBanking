package org.sanaa.ebanking.brif9.ebanking.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Request.RoleRequestDTO;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Response.RoleResponseDTO;
import org.sanaa.ebanking.brif9.ebanking.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;


    @PostMapping
    public ResponseEntity<RoleResponseDTO> create(@Valid @RequestBody RoleRequestDTO roleRequestDTO) {
        RoleResponseDTO responseDTO = roleService.create(roleRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

}
