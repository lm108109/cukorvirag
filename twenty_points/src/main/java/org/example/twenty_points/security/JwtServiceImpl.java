package org.example.twenty_points.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.example.twenty_points.security.JwtService;
import org.example.twenty_points.security.model.LoginResponse;
import org.springframework.beans.factory.annotation.Value;

import java.time.ZonedDateTime;
import java.util.Date;

public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    private static final String JWT_Prefix = "Bearer ";

    @Override
    public boolean verifyJWTToken(String token){
        if (token == null || token.isEmpty()) {
            return false;
        }
        token = token.replace(JWT_Prefix, "");
        Algorithm algorithm = Algorithm.HMAC256(secret);

        try {
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    @Override
    public Long getSubjectFromToken(String token){
        token = token.replace(JWT_Prefix, "");
        DecodedJWT jwt = JWT.decode(token);
        return Long.parseLong(jwt.getSubject());
    }

    @Override
    public LoginResponse generateLoginToken(Long sessionId, Long userId, String role) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        String jwtToken = JWT.create()
                .withSubject(String.valueOf(sessionId))
                .withClaim("userId", userId)
                .withClaim("role", role)
                .withExpiresAt(getExpirationDate(expiration))
                .sign(algorithm);
        return LoginResponse.builder().token(jwtToken).build();
    }

    private Date getExpirationDate(Long expiration) {
        return Date.from(ZonedDateTime.now().plusMinutes(expiration).toInstant());
    }
}
