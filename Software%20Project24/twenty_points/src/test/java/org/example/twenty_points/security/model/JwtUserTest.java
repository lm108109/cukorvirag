package org.example.twenty_points.security.model;

import org.example.twenty_points.model.entity.Role;
import org.example.twenty_points.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class JwtUserTest {

    @Test
    void testGetAuthorities() {
        User user = new User();
        Role role = new Role();
        role.setCode("ROLE_USER");

        JwtUser jwtUser = new JwtUser(user, role);
        Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();

        assertEquals(1, authorities.size());
        assertTrue(authorities.stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_USER")));
    }

    @Test
    void testGetPassword() {
        User user = new User();
        user.setPassword("password");

        JwtUser jwtUser = new JwtUser(user, new Role());
        assertEquals("password", jwtUser.getPassword());
    }

    @Test
    void testGetUsername() {
        User user = new User();
        user.setUsername("username");

        JwtUser jwtUser = new JwtUser(user, new Role());
        assertEquals("username", jwtUser.getUsername());
    }

    @Test
    void testIsAccountNonExpired() {
        JwtUser jwtUser = new JwtUser(new User(), new Role());
        assertTrue(jwtUser.isAccountNonExpired());
    }

    @Test
    void testIsAccountNonLocked() {
        JwtUser jwtUser = new JwtUser(new User(), new Role());
        assertTrue(jwtUser.isAccountNonLocked());
    }

    @Test
    void testIsCredentialsNonExpired() {
        JwtUser jwtUser = new JwtUser(new User(), new Role());
        assertTrue(jwtUser.isCredentialsNonExpired());
    }

    @Test
    void testIsEnabled() {
        User user = new User();
        user.setActive(true);

        JwtUser jwtUser = new JwtUser(user, new Role());
        assertTrue(jwtUser.isEnabled());
    }
}