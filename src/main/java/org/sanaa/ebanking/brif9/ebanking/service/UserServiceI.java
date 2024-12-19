package org.sanaa.ebanking.brif9.ebanking.service;

import org.sanaa.ebanking.brif9.ebanking.models.dto.Request.PasswordChangeDTO;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Request.UserRequestDTO;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Response.UserResponseDTO;

import java.util.List;

public interface UserServiceI {
    UserResponseDTO register(UserRequestDTO requestDTO);
    void changePassword(String username, PasswordChangeDTO passwordChangeDTO);
    UserResponseDTO getCurrentUser(String username);
    List<UserResponseDTO> getAllUsers();
}
