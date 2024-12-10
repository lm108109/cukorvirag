package org.example.twenty_points.controller;

import org.example.twenty_points.model.dto.CookieDto;
import org.example.twenty_points.model.entity.Cookie;
import org.example.twenty_points.repository.CookieRepository;
import org.example.twenty_points.service.CookieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CookieControllerTest {
	
	private CookieService cookieService;
	private CookieRepository cookieRepository;
	private CookieController cookieController;
	
	@BeforeEach
	void setUp() {
		cookieService = mock(CookieService.class);
		cookieRepository = mock(CookieRepository.class);
		cookieController = new CookieController(cookieService, cookieRepository);
	}
	
	@Test
	void getCookieShouldReturnListOfCookies() {
		List<CookieDto> cookies = Collections.singletonList(new CookieDto());
		when(cookieService.getCookie()).thenReturn(cookies);
		
		ResponseEntity<List<CookieDto>> response = cookieController.getCookie();
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(cookies);
	}
	
	@Test
	void getCookieByIdShouldReturnCookieWhenFound() {
		Cookie cookie = new Cookie();
		when(cookieRepository.findById(1L)).thenReturn(Optional.of(cookie));
		
		ResponseEntity<CookieDto> response = cookieController.getCookieById(1L);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(new CookieDto(cookie));
	}
	
	@Test
	void getCookieByIdShouldReturnNotFoundWhenNotFound() {
		when(cookieRepository.findById(1L)).thenReturn(Optional.empty());
		
		ResponseEntity<CookieDto> response = cookieController.getCookieById(1L);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
	
	@Test
	void addCookieShouldReturnCookieWhenNotExists() {
		when(cookieRepository.findCookieByName("newCookie")).thenReturn(null);
		CookieDto newCookie = new CookieDto();
		when(cookieService.addCookie("newCookie", "description")).thenReturn(newCookie);
		
		ResponseEntity<CookieDto> response = cookieController.addCookie("newCookie", "description");
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(newCookie);
	}
	
	@Test
	void addCookieShouldReturnConflictWhenExists() {
		Cookie existingCookie = new Cookie();
		when(cookieRepository.findCookieByName("existingCookie")).thenReturn(existingCookie);
		
		ResponseEntity<CookieDto> response = cookieController.addCookie("existingCookie", "description");
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
	}
}