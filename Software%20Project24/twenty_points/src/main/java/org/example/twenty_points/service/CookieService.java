package org.example.twenty_points.service;

import org.example.twenty_points.model.dto.CookieDto;

import java.util.List;

public interface CookieService {

    List<CookieDto> getCookie();

    CookieDto addCookie(String name, String description);
}
