package org.sanaa.ebanking.brif9.ebanking.service;

import org.sanaa.ebanking.brif9.ebanking.models.dto.Request.UserRequestDTO;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Response.UserResponseDTO;
import org.sanaa.ebanking.brif9.ebanking.models.entity.EbankUser;
import org.sanaa.ebanking.brif9.ebanking.models.mapper.UserMapper;
import org.sanaa.ebanking.brif9.ebanking.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceI {

private final UserRepository userRepository;
private final UserMapper userMapper;
private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserResponseDTO register (UserRequestDTO requestDTO){
        String encodedPassword = passwordEncoder.encode(requestDTO.getPassword());
        requestDTO.setPassword(encodedPassword);
        EbankUser user = userMapper.toEntity(requestDTO);
        EbankUser savedUser = userRepository.save(user);
        return userMapper.toResponseDTO(savedUser);
    }
}
