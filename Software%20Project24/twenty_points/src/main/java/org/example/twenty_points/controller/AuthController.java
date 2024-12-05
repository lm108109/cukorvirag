package org.example.twenty_points.controller;

import com.nimbusds.openid.connect.sdk.LogoutRequest;
import groovy.util.logging.Slf4j;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
<<<<<<< HEAD
=======
import org.example.twenty_points.exception.RoleNotFoundException;
>>>>>>> backend
import org.example.twenty_points.model.dto.LoginRequest;
import org.example.twenty_points.model.dto.RegistrationModifyDto;
import org.example.twenty_points.model.dto.UserQueryDto;
import org.example.twenty_points.security.model.LoginResponse;
import org.example.twenty_points.service.AuthService;
import org.example.twenty_points.service.LogoutService;
import org.json.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "Authentication API")
@RestController
@CrossOrigin
@RequestMapping("/rest/auth")
public class AuthController {

    private final AuthService authService;
    private final LogoutService logoutService;

    public AuthController(AuthService authService, LogoutService logoutService) {
        this.authService = authService;
        this.logoutService = logoutService;
    }

    @Operation(summary = "Login")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.authLogin(loginRequest));
    }

    @Operation(summary = "Logout")
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request, HttpServletResponse response) {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            logoutService.logout(request, response, auth);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @Operation(summary = "Registration.")
    @PostMapping("/registration")
    public ResponseEntity<UserQueryDto> registration(@RequestBody @Valid RegistrationModifyDto request){
        return ResponseEntity.ok(authService.registration(request));
    }
}
