package org.example.twenty_points.service.impl;

import org.example.twenty_points.exception.RoleNotFoundException;
import org.example.twenty_points.model.dto.LoginRequest;
import org.example.twenty_points.model.dto.RegistrationModifyDto;
import org.example.twenty_points.model.dto.UserQueryDto;
import org.example.twenty_points.model.entity.Role;
import org.example.twenty_points.model.entity.Session;
import org.example.twenty_points.model.entity.User;
import org.example.twenty_points.repository.RoleRepository;
import org.example.twenty_points.repository.SessionRepository;
import org.example.twenty_points.repository.UserRepository;
import org.example.twenty_points.security.JwtService;
import org.example.twenty_points.security.model.LoginResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthServiceImplTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private SessionRepository sessionRepository;

    @InjectMocks
    private AuthServiceImpl authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void authLoginReturnsLoginResponse() {
//        LoginRequest req = new LoginRequest("username", "password");
//        User user = new User();
//        user.setPassword("encodedPassword");
//        Session session = new Session();
//        session.setExpirationDate(LocalDateTime.now().plusHours(1));
//        LoginResponse loginResponse = new LoginResponse("token");
//
//        when(userRepository.findByUsername(req.getUsername())).thenReturn(Optional.of(user));
//        when(passwordEncoder.matches(req.getPassword(), user.getPassword())).thenReturn(true);
//        when(sessionRepository.save(any(Session.class))).thenReturn(session);
//        when(jwtService.generateLoginToken(anyLong(), anyLong(), anyString())).thenReturn(loginResponse);
//
//        LoginResponse response = authService.authLogin(req);
//
//        assertEquals("token", response.getToken());
//    }

    @Test
    void authLoginThrowsExceptionForInvalidUsername() {
        LoginRequest req = new LoginRequest("username", "password");

        when(userRepository.findByUsername(req.getUsername())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> authService.authLogin(req));
    }

    @Test
    void authLoginThrowsExceptionForInvalidPassword() {
        LoginRequest req = new LoginRequest("username", "password");
        User user = new User();
        user.setPassword("encodedPassword");

        when(userRepository.findByUsername(req.getUsername())).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(req.getPassword(), user.getPassword())).thenReturn(false);

        assertThrows(RuntimeException.class, () -> authService.authLogin(req));
    }

//    @Test
//    void registrationReturnsUserQueryDto() {
//        RegistrationModifyDto registrationModifyDto = new RegistrationModifyDto();
//        registrationModifyDto.setUsername("username");
//        registrationModifyDto.setRoleCode("roleCode");
//        Role role = new Role();
//        User user = new User();
//
//        when(userRepository.existsByUsername(registrationModifyDto.getUsername())).thenReturn(false);
//        when(roleRepository.findByCode(registrationModifyDto.getRoleCode())).thenReturn(Optional.of(role));
//        when(userRepository.save(any(User.class))).thenReturn(user);
//
//        UserQueryDto userQueryDto = authService.registration(registrationModifyDto);
//
//        assertNotNull(userQueryDto);
//    }
//
//    @Test
//    void registrationThrowsExceptionForExistingUsername() {
//        RegistrationModifyDto registrationModifyDto = new RegistrationModifyDto();
//        registrationModifyDto.setUsername("username");
//
//        when(userRepository.existsByUsername(registrationModifyDto.getUsername())).thenReturn(true);
//
//        Exception exception = assertThrows(RuntimeException.class, () -> authService.registration(registrationModifyDto));
//
//        String expectedMessage = "Username already exists";
//        String actualMessage = exception.getMessage();
//
//        assertTrue(actualMessage.contains(expectedMessage), "Expected exception message to contain 'Username already exists'");
//    }
//
//    @Test
//    void registrationThrowsExceptionForInvalidRoleCode() {
//        RegistrationModifyDto registrationModifyDto = new RegistrationModifyDto();
//        registrationModifyDto.setRoleCode("roleCode");
//
//        when(userRepository.existsByUsername(registrationModifyDto.getUsername())).thenReturn(false);
//        when(roleRepository.findByCode(registrationModifyDto.getRoleCode())).thenReturn(Optional.empty());
//
//        assertThrows(RoleNotFoundException.class, () -> authService.registration(registrationModifyDto));
//    }
}