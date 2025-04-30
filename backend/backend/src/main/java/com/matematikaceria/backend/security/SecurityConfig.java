package com.matematikaceria.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // nonaktifkan CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll() // izinkan semua endpoint
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()); // basic config

        return http.build();
    }
}
