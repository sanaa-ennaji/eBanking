package org.sanaa.ebanking.brif9.ebanking.service;


import org.sanaa.ebanking.brif9.ebanking.models.entity.EbankUser;
import org.sanaa.ebanking.brif9.ebanking.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EbankUser ebankUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return EbankUser.builder()
                .username(ebankUser.getUsername())
                .password(ebankUser.getPassword())
                .roles(ebankUser.getRoles().stream().map(role -> role.getRoleName().substring(5)).toArray(String[]::new))
                .build();
    }
}