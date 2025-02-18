package com.codingcohorts.config; // Update this based on your package structure

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF (required for H2)
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable())) // Allow H2 frames
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/h2-console/**").permitAll() // Allow access to H2 console
                                .anyRequest().permitAll() // Allow all other requests
                );
        return http.build();
    }
}
