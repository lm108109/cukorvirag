package org.example.twenty_points.service.impl;

import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.twenty_points.model.entity.Session;
import org.example.twenty_points.repository.SessionRepository;
import org.example.twenty_points.security.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class LogoutServiceImplTest {

    @Mock
    private SessionRepository sessionRepository;

    @Mock
    private JwtService jwtService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private Authentication authentication;

    @InjectMocks
    private LogoutServiceImpl logoutService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void logout_withValidToken_updatesSessionExpiration() {
        String authToken = "Bearer validToken";
        Session session = new Session();
        session.setExpirationDate(LocalDateTime.now().plusMinutes(10));

        when(request.getHeader("Authorization")).thenReturn(authToken);
        when(jwtService.verifyJWTToken(authToken)).thenReturn(true);
        when(jwtService.getSubjectFromToken(authToken)).thenReturn(1L);
        when(sessionRepository.getSessionById(1L)).thenReturn(Optional.of(session));

        logoutService.logout(request, response, authentication);

        assertTrue(session.getExpirationDate().isBefore(LocalDateTime.now()));
        verify(sessionRepository).save(session);
    }

    @Test
    void logout_withExpiredToken_throwsJWTVerificationException() {
        String authToken = "Bearer expiredToken";
        Session session = new Session();
        session.setExpirationDate(LocalDateTime.now().minusMinutes(10));

        when(request.getHeader("Authorization")).thenReturn(authToken);
        when(jwtService.verifyJWTToken(authToken)).thenReturn(true);
        when(jwtService.getSubjectFromToken(authToken)).thenReturn(1L);
        when(sessionRepository.getSessionById(1L)).thenReturn(Optional.of(session));

        assertThrows(JWTVerificationException.class, () -> logoutService.logout(request, response, authentication));
    }

    @Test
    void logout_withInvalidToken_doesNothing() {
        String authToken = "Bearer invalidToken";

        when(request.getHeader("Authorization")).thenReturn(authToken);
        when(jwtService.verifyJWTToken(authToken)).thenReturn(false);

        logoutService.logout(request, response, authentication);

        verify(sessionRepository, never()).save(any(Session.class));
    }

    @Test
    void logout_withNoAuthToken_doesNothing() {
        when(request.getHeader("Authorization")).thenReturn(null);

        logoutService.logout(request, response, authentication);

        verify(sessionRepository, never()).save(any(Session.class));
    }

    @Test
    void logout_withNonBearerToken_doesNothing() {
        String authToken = "NonBearer token";

        when(request.getHeader("Authorization")).thenReturn(authToken);

        logoutService.logout(request, response, authentication);

        verify(sessionRepository, never()).save(any(Session.class));
    }
}