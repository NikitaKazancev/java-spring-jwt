package ru.nk.rschir.authentication.routes.components;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.nk.rschir.authentication.jwt.JwtService;
import ru.nk.rschir.authentication.routes.dto.AuthRequestDTO;
import ru.nk.rschir.authentication.routes.dto.AuthResponseDTO;
import ru.nk.rschir.users.Role;
import ru.nk.rschir.users.User;
import ru.nk.rschir.users.UserRepo;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    public User getUserByHttpRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return userRepo
                    .findByEmail(jwtService.getEmail(authHeader.substring(7)))
                    .orElse(null);
        }

        return null;
    }
    public User findUserByJwt(String jwt) {
        return userRepo
                .findByEmail(jwtService.getEmail(jwt))
                .orElse(null);
    }
    public boolean isNotAdmin(HttpServletRequest request) {
        User user = getUserByHttpRequest(request);
        return user == null || user.getRole() != Role.ADMIN;
    }
    public AuthResponseDTO register(AuthRequestDTO requestData) {
        return register(requestData, Role.USER);
    }
    public AuthResponseDTO register(AuthRequestDTO requestData, Role role) {
        Optional<User> dbUser = userRepo.findByEmail(requestData.getEmail());
        if (dbUser.isPresent()) {
            return AuthResponseDTO.builder().jwt(null).status(409).build();
        }

        User user = User.builder()
                .email(requestData.getEmail())
                .password(passwordEncoder.encode(requestData.getPassword()))
                .role(role)
                .build();

        userRepo.save(user);

        return AuthResponseDTO.builder()
                .jwt(jwtService.createToken(user))
                .status(200)
                .build();
    }
    public AuthResponseDTO login(AuthRequestDTO authData) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authData.getEmail(),
                        authData.getPassword()
                )
        );

        User user = userRepo.findByEmail(authData.getEmail())
                .orElseThrow();

        return AuthResponseDTO.builder()
                .jwt(jwtService.createToken(user))
                .status(200)
                .build();
    }
}





