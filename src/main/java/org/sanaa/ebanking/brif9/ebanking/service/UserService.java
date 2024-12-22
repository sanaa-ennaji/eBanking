package org.sanaa.ebanking.brif9.ebanking.service;

import org.sanaa.ebanking.brif9.ebanking.models.dto.Request.PasswordChangeDTO;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Request.UserRequestDTO;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Response.UserResponseDTO;
import org.sanaa.ebanking.brif9.ebanking.models.entity.EbankRole;
import org.sanaa.ebanking.brif9.ebanking.models.entity.EbankUser;
import org.sanaa.ebanking.brif9.ebanking.models.mapper.UserMapper;
import org.sanaa.ebanking.brif9.ebanking.repository.RoleRepository;
import org.sanaa.ebanking.brif9.ebanking.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceI {

private final UserRepository userRepository;
private final RoleRepository roleRepository;
private final UserMapper userMapper;
private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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
    @Override
    public void changePassword(String username, PasswordChangeDTO passwordChangeDTO) {
        EbankUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (!passwordEncoder.matches(passwordChangeDTO.getCurrentPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Current password is incorrect");
        }
        user.setPassword(passwordEncoder.encode(passwordChangeDTO.getNewPassword()));
        userRepository.save(user);
    }

   @Override
    public UserResponseDTO getCurrentUser(String username) {
        EbankUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return userMapper.toResponseDTO(user);
    }
    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<EbankUser> users = userRepository.findAll();
        return users.stream().map(userMapper::toResponseDTO).toList();
    }
    @Override
    public void deleteUserByUsername(String username) {
        EbankUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        userRepository.delete(user);
    }

    public void updateUserRole(String username, String newRole) {
        EbankUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        EbankRole role = roleRepository.findByRoleName(newRole)
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));

        user.setRole(role);
        userRepository.save(user);
    }



}
