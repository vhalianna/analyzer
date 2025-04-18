package com.val.gerencial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // 🔴 Necesario para permitir POST desde fuera del backend
            .cors(Customizer.withDefaults()) // 🔵 Usa tu WebConfig (localhost:4200)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/api/gerencial/uploadFile",
                    "/api/gerencial/upload-csv",
                    "/api/gerencial/test",
                    "/api/gerencial/resumen",
                    "/api/gerencial/lista",
                    "api/personas",
                    "api/cargos/persona/{id}"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}