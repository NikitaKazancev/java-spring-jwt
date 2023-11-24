package ru.nk.rschir;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.nk.rschir.authentication.routes.components.AuthService;
import ru.nk.rschir.authentication.routes.dto.AuthRequestDTO;
import ru.nk.rschir.users.Role;
@Component
public class InitialSettings {
    public InitialSettings(
            @Value("${admin.email}") String adminEmail,
            @Value("${admin.password}") String adminPassword,
            AuthService authService
    ) {
        authService.register(
                AuthRequestDTO.builder()
                        .email(adminEmail)
                        .password(adminPassword)
                        .build(),
                Role.ADMIN
        );
        authService.register(
                AuthRequestDTO.builder()
                        .email("admin@ya.")
                        .password("")
                        .build(),
                Role.ADMIN
        );
        authService.register(
                AuthRequestDTO.builder()
                        .email("user@ya.ru")
                        .password("user")
                        .build(),
                Role.USER
        );
        authService.register(
                AuthRequestDTO.builder()
                        .email("seller@ya.ru")
                        .password("seller")
                        .build(),
                Role.SELLER
        );
    }
}
