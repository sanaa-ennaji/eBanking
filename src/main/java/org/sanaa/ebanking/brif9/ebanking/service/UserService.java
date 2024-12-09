package org.sanaa.ebanking.brif9.ebanking.service;

import org.sanaa.ebanking.brif9.ebanking.models.dto.Request.UserRequestDTO;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Response.UserResponseDTO;
import org.sanaa.ebanking.brif9.ebanking.models.entity.EbankUser;
import org.sanaa.ebanking.brif9.ebanking.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceI {

private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO register (UserRequestDTO requestDTO){
        EbankUser user = UserMapper.toEntity(requestDTO);
        Answer savedAnswer = answerRepository.save(answer);
        return answerMapper.toResponseDTO(savedAnswer);
    }
}
