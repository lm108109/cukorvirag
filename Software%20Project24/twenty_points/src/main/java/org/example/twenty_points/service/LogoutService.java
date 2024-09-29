package org.example.twenty_points.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;

public interface LogoutService {

    void logout(HttpServletRequest req, HttpServletResponse res, Authentication auth);

}
