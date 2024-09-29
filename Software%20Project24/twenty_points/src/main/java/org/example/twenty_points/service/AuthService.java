package org.example.twenty_points.service;

import jakarta.validation.Valid;
import org.example.twenty_points.model.dto.LoginRequest;
import org.example.twenty_points.model.dto.RegistrationModifyDto;
import org.example.twenty_points.model.dto.UserQueryDto;
import org.example.twenty_points.security.model.LoginResponse;

public interface AuthService {

    LoginResponse authLogin(@Valid LoginRequest req);

    //UserQueryDto registration(RegistrationModifyDto registrationModifyDto);
}
