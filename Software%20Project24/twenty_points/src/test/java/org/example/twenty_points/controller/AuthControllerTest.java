package org.example.twenty_points.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.twenty_points.exception.RoleNotFoundException;
import org.example.twenty_points.model.dto.LoginRequest;
import org.example.twenty_points.model.dto.RegistrationModifyDto;
import org.example.twenty_points.model.dto.UserQueryDto;
import org.example.twenty_points.security.model.LoginResponse;
import org.example.twenty_points.service.AuthService;
import org.example.twenty_points.service.LogoutService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AuthControllerTest {
	
	@Mock
	private AuthService authService;
	
	@Mock
	private LogoutService logoutService;
	
	@InjectMocks
	private AuthController authController;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void loginShouldReturnOkWithValidCredentials() {
		LoginRequest loginRequest = new LoginRequest("validUser", "validPassword");
		when(authService.authLogin(loginRequest)).thenReturn(new LoginResponse("validToken"));
		ResponseEntity<LoginResponse> response = authController.login(loginRequest);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getToken()).isEqualTo("validToken");
	}
	
	@Test
	void loginShouldReturnBadRequestWithInvalidCredentials() {
		LoginRequest loginRequest = new LoginRequest("invalidUser", "invalidPassword");
		when(authService.authLogin(loginRequest)).thenThrow(new BadCredentialsException("Invalid credentials"));
		assertThrows(BadCredentialsException.class, () -> authController.login(loginRequest));
	}
	
	@Test
	void logoutShouldReturnOkWhenAuthenticated() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		Authentication auth = mock(Authentication.class);
		SecurityContextHolder.getContext().setAuthentication(auth);
		ResponseEntity<Void> responseEntity = authController.logout(request, response);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	void logoutShouldReturnUnauthorizedWhenNotAuthenticated() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		SecurityContextHolder.getContext().setAuthentication(null);
		ResponseEntity<Void> responseEntity = authController.logout(request, response);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
	}
	
	@Test
	void registrationShouldReturnOkWithValidRequest() {
		RegistrationModifyDto request = new RegistrationModifyDto("validName", "validUser", "validRole", true);
		UserQueryDto userQueryDto = UserQueryDto.builder()
				.username("validUser")
				.name("validName")
				.build();
		when(authService.registration(request)).thenReturn(userQueryDto);
		ResponseEntity<UserQueryDto> response = authController.registration(request);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getUsername()).isEqualTo("validUser");
		assertThat(response.getBody().getName()).isEqualTo("validName");
	}
	
	@Test
	void registrationShouldReturnBadRequestWithInvalidRequest() {
		RegistrationModifyDto request = new RegistrationModifyDto("", "", "invalidRole", false);
		when(authService.registration(request)).thenThrow(new RoleNotFoundException("Invalid role"));
		assertThrows(RoleNotFoundException.class, () -> authController.registration(request));
	}
}
