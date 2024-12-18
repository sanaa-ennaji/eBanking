package org.sanaa.ebanking.brif9.ebanking.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sanaa.ebanking.brif9.ebanking.models.dto.LoginRequestDTO;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Request.PasswordChangeDTO;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Request.UserRequestDTO;
import org.sanaa.ebanking.brif9.ebanking.models.dto.Response.UserResponseDTO;
import org.sanaa.ebanking.brif9.ebanking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO responseDTO = userService.register(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequest) {
        try {

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUserName(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            return ResponseEntity.ok("User logged in successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(
            @RequestBody PasswordChangeDTO passwordChangeDTO,
            Authentication authentication) {
        userService.changePassword(authentication.getName(), passwordChangeDTO);
        return ResponseEntity.ok("Password updated");
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponseDTO> getCurrentUser(Authentication authentication) {
        UserResponseDTO user = userService.getCurrentUser(authentication.getName());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }


}
