package org.sanaa.ebanking.brif9.ebanking.config;


import org.sanaa.ebanking.brif9.ebanking.exception.CustomAccessDeniedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .exceptionHandling(exceptions ->
                        exceptions
                                .accessDeniedHandler(new CustomAccessDeniedHandler())
                )
                 .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/api/v1/notices", "/api/v1/contact", "/api/v1/register", "/api/v1/roles", "/api/v1/login").permitAll()
                        .requestMatchers("/api/users/**" , "/api/v1/change-password").hasRole("ADMIN")
                        .requestMatchers("/api/v1/myLoans", "/api/v1/myCards", "/api/v1/myAccount", "/api/v1/myBalance")
                        .authenticated()
                        .anyRequest().authenticated()
                )
                .httpBasic(basic -> {});

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}