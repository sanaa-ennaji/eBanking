package org.sanaa.ebanking.brif9.ebanking.service;

import org.sanaa.ebanking.brif9.ebanking.models.dto.Request.PasswordChangeDTO;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Request.UserRequestDTO;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Response.UserResponseDTO;
import org.sanaa.ebanking.brif9.ebanking.models.entity.EbankUser;
import org.sanaa.ebanking.brif9.ebanking.models.mapper.UserMapper;
import org.sanaa.ebanking.brif9.ebanking.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void changePassword(String username, PasswordChangeDTO passwordChangeDTO) {
        EbankUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (!passwordEncoder.matches(passwordChangeDTO.getCurrentPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Current password is incorrect");
        }
        user.setPassword(passwordEncoder.encode(passwordChangeDTO.getNewPassword()));
        userRepository.save(user);
    }


    public UserResponseDTO getCurrentUser(String username) {
        EbankUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return userMapper.toResponseDTO(user);
    }

    public List<UserResponseDTO> getAllUsers() {
        List<EbankUser> users = userRepository.findAll();
        return users.stream().map(userMapper::toResponseDTO).toList();
    }
}
