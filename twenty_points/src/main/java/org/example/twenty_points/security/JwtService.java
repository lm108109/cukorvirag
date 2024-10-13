package org.example.twenty_points.security;

import org.example.twenty_points.security.model.LoginResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

//@Repository
public interface JwtService {
    /**
     * Validation of the JWT Token
     *
     * @param token - JWT token
     *
     */
    public boolean verifyJWTToken(String token);

    /**
     * Get the Subject from the Token
     * @param token - JWT Token
     */
    public Long getSubjectFromToken(String token);

    /**
     *
     * Generate Login token
     *
     */
    public LoginResponse generateLoginToken(Long sessionId, Long userId, String role);
}
