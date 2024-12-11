package org.example.twenty_points.service.impl;

import org.example.twenty_points.model.dto.CookieDto;
import org.example.twenty_points.model.entity.Cookie;
import org.example.twenty_points.repository.CookieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

class CookieServiceImplTest {

    @Mock
    private CookieRepository repository;

    @InjectMocks
    private CookieServiceImpl cookieService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCookie_returnsListOfCookieDtos() {
        Cookie cookie1 = new Cookie();
        cookie1.setName("Cookie1");
        cookie1.setDescription("Description1");

        Cookie cookie2 = new Cookie();
        cookie2.setName("Cookie2");
        cookie2.setDescription("Description2");

        when(repository.findAll()).thenReturn(Arrays.asList(cookie1, cookie2));

        List<CookieDto> result = cookieService.getCookie();

        assertEquals(2, result.size());
        assertEquals("Cookie1", result.get(0).getName());
        assertEquals("Description1", result.get(0).getDescription());
        assertEquals("Cookie2", result.get(1).getName());
        assertEquals("Description2", result.get(1).getDescription());
    }

    @Test
    void getCookie_withNoCookies_returnsEmptyList() {
        when(repository.findAll()).thenReturn(Arrays.asList());

        List<CookieDto> result = cookieService.getCookie();

        assertTrue(result.isEmpty());
    }

    @Test
    void addCookie_withValidData_returnsCookieDto() {
        Cookie cookie = new Cookie();
        cookie.setId(1L);
        cookie.setName("NewCookie");
        cookie.setDescription("NewDescription");

        when(repository.findMaxId()).thenReturn(0L);
        when(repository.save(any(Cookie.class))).thenReturn(cookie);

        CookieDto result = cookieService.addCookie("NewCookie", "NewDescription");

        assertNotNull(result);
        assertEquals("NewCookie", result.getName());
        assertEquals("NewDescription", result.getDescription());
    }
}