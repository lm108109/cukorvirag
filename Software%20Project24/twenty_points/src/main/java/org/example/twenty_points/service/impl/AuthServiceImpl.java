package org.example.twenty_points.service.impl;

import lombok.SneakyThrows;
import org.example.twenty_points.exception.RoleNotFoundException;
import org.example.twenty_points.model.dto.RegistrationModifyDto;
import org.example.twenty_points.model.dto.UserQueryDto;
import org.example.twenty_points.util.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.example.twenty_points.model.dto.LoginRequest;
import org.example.twenty_points.model.entity.Role;
import org.example.twenty_points.model.entity.Session;
import org.example.twenty_points.model.entity.User;
import org.example.twenty_points.repository.RoleRepository;
import org.example.twenty_points.repository.SessionRepository;
import org.example.twenty_points.repository.UserRepository;
import org.example.twenty_points.security.JwtService;
import org.example.twenty_points.security.model.LoginResponse;
import org.example.twenty_points.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Value("${jwt.expiration}")
    private Long expiration;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;

    public AuthServiceImpl(JwtService jwtService,
                           RoleRepository roleRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           SessionRepository sessionRepository) {
        this.jwtService = jwtService;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.sessionRepository = sessionRepository;
    }
    @Override
    public LoginResponse authLogin(LoginRequest req) {
        User user = loginUser(req);
        Session session = createSession(user, req);
        sessionRepository.save(session);
        return generateJwtTokenAndUpdateSession(session, user);
    }

    @Override
    public UserQueryDto registration(RegistrationModifyDto registrationModifyDto) {
        return null;
    }

    /**
     * Create a login user object by username and password.
     *
     * @param req - login request dto
     */
    private User loginUser(LoginRequest req) {
        User user = userRepository.findByUsername(req.getUsername())
                .orElseThrow(() -> new RuntimeException("Hibás felhasználónév vagy jelszó"));

        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Hibás felhasználónév vagy jelszó");
        }
        return user;
    }

    /**
     * Create session and previous session set to expire.
     *
     * @param user - user to login
     * @param req - required data
     */
    private Session createSession(User user, LoginRequest req){
        Role role = user.getRole();
        Session newSession = Session.builder()
                .user(user)
                .role(role)
                .creationDate(LocalDateTime.now())
                .expirationDate(LocalDateTime.now().plusMinutes(expiration))
                .build();

        Optional<Session> optSession = sessionRepository.getLastSessionUserId(user.getId());
        if ( optSession.isPresent() ){
            Session prevSession = optSession.get();
            if( prevSession.getExpirationDate().isAfter(LocalDateTime.now()) ){
                prevSession.setExpirationDate(LocalDateTime.now().minusMinutes(1));
                sessionRepository.save(prevSession);
            }
            newSession.setPrevSession(prevSession);
        }

        newSession = sessionRepository.save(newSession);
        return newSession;
    }

    /**
     * Generation the session with the JWT token.
     *
     * @param session - created session
     * @param user - login user
     */
    private LoginResponse generateJwtTokenAndUpdateSession(Session session, User user) {
        LoginResponse response = jwtService.generateLoginToken(session.getId(), user.getId(), session.getRole().getCode());
        session.setJwtToken(response.getToken());
        sessionRepository.save(session);
        return response;
    }

   /* public UserQueryDto registration(RegistrationModifyDto registrationModifyDto){
        public UserQueryDto registration registrationModifyDto)  {

        if ( userRepository.existsByUsername(registrationModifyDto.getUsername()) ){
            throw new RuntimeException("Username already exists");
        }

        Role role = roleRepository.findByCode(registrationModifyDto.getRoleCode()).orElseThrow(RoleNotFoundException::new);

        User user = new User();
        Mapper.map(registrationModifyDto, user);
        user.setId(userRepository.findMaxId() + 1);
        user.setPassword(passwordEncoder.encode(registrationModifyDto.getUsername()));
        user.setActive(true);
        user.setRole(role);

        user = userRepository.save(user);
        return new UserQueryDto(user);
    }*/
}
