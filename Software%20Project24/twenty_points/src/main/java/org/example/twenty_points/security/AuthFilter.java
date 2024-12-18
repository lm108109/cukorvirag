package org.example.twenty_points.security;

import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.twenty_points.model.entity.Session;
import org.example.twenty_points.repository.SessionRepository;
import org.example.twenty_points.security.model.JwtUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class AuthFilter extends OncePerRequestFilter {

    private final SessionRepository sessionRepository;
    private final JwtService jwtService;
    private static final String AUTH_HEADER = "Authorization";

    public AuthFilter(SessionRepository sessionRepository, JwtService jwtService) {
        this.sessionRepository = sessionRepository;
        this.jwtService = jwtService;

    }

    private static ThreadLocal<Session> jwtSession = new ThreadLocal<>();
    public static Session getJwtSession() { return jwtSession.get(); }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException{
        //Instant start = Instant.now();
        Session session = null;
        final String authToken = request.getHeader(AUTH_HEADER);

        if (jwtService.verifyJWTToken(authToken)) {
            session = getSessionFromToken(authToken);
            jwtSession.set(session);

            if (session == null || session.getExpirationDate().isBefore(LocalDateTime.now())) {
                throw new JWTVerificationException("Expired JWT token");
            }

            JwtUser user = new JwtUser(session.getUser(), session.getRole());
            var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            if (user.isEnabled()){
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        filterChain.doFilter(request, response);

        jwtSession.remove();
    }
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//        final String authToken = request.getHeader(AUTH_HEADER);
//
//        if (authToken == null || !authToken.startsWith("Bearer ")) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or malformed Authorization header");
//            return;
//        }
//
//        if (!jwtService.verifyJWTToken(authToken)) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or expired JWT token");
//            return;
//        }
//
//        Session session = getSessionFromToken(authToken);
//        if (session == null) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Session not found");
//            return;
//        }
//
//        if (session.getExpirationDate().isBefore(LocalDateTime.now())) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Session has expired");
//            return;
//        }
//
//        JwtUser user = new JwtUser(session.getUser(), session.getRole());
//        if (!user.isEnabled()) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User is not enabled");
//            return;
//        }
//
//        var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//
//        SecurityContextHolder.getContext().setAuthentication(auth);
//        logger.info("User authorities: " + SecurityContextHolder.getContext().getAuthentication().getAuthorities());
//
//        filterChain.doFilter(request, response);
//    }


    private Session getSessionFromToken(String authToken) {
        Long sessionId = jwtService.getSubjectFromToken(authToken);
        return sessionRepository.getSessionById(sessionId).orElse(null);
    }
}
