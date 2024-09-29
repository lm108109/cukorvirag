package org.example.twenty_points.service.impl;

import com.auth0.jwt.exceptions.JWTVerificationException;
import org.example.twenty_points.model.entity.Session;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.twenty_points.repository.SessionRepository;
import org.example.twenty_points.security.JwtService;
import org.example.twenty_points.service.LogoutService;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogoutServiceImpl implements LogoutService, LogoutHandler {

    private final SessionRepository sessionRepository;
    private final JwtService jwtService;
    private static final String AUTH_HEADER = "Authorization";
    private static final String JWT_PREFIX = "Bearer ";

    private static final ThreadLocal<Session> jwtSession = new ThreadLocal<>();
    public static Session getJwtSession() {
        return jwtSession.get();
    }

    public LogoutServiceImpl(SessionRepository sessionRepository, JwtService jwtService)
    {
        this.sessionRepository = sessionRepository;
        this.jwtService = jwtService;
    }

    @Override
    public void logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Authentication authentication
    ) {
        final String authToken = request.getHeader(AUTH_HEADER);
        Session session = null;
        if (authToken == null || !authToken.startsWith(JWT_PREFIX))
        {
            return;
        }
        if (jwtService.verifyJWTToken(authToken)) {
            Long sessionId = jwtService.getSubjectFromToken(authToken);
            session = sessionRepository.getSessionById(sessionId).orElse(null);
            jwtSession.set(session);

            if (session == null || session.getExpirationDate().isBefore(LocalDateTime.now())) {
                throw new JWTVerificationException("Expired token!");
            }


            if (session.getExpirationDate().isAfter(LocalDateTime.now()))
            {
                session.setExpirationDate(LocalDateTime.now().minusMinutes(1));
                sessionRepository.save(session);
            }
        }

        jwtSession.remove();
    }
}
