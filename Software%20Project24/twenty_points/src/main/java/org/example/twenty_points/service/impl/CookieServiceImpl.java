package org.example.twenty_points.service.impl;

import org.example.twenty_points.model.dto.CookieDto;
import org.example.twenty_points.model.entity.Cookie;
import org.example.twenty_points.repository.CookieRepository;
import org.example.twenty_points.service.CookieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CookieServiceImpl implements CookieService {

    private final CookieRepository repository;
    public CookieServiceImpl(CookieRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<CookieDto> getCookie() {
        List<CookieDto> cookieDtos = new ArrayList<>();
        repository.findAll().forEach(sutis ->{
                CookieDto cookieDto = new CookieDto();
                cookieDto.setName(sutis.getName());
                cookieDto.setDescription(sutis.getDescription());
                cookieDtos.add(new CookieDto(sutis));
        });
        return cookieDtos;
    }

    @Override
    public CookieDto addCookie(String name, String description) {
        Cookie cookie = new Cookie();
        cookie.setId(repository.findMaxId() + 1);
        cookie.setName(name);
        cookie.setDescription(description);
        repository.save(cookie);
        return new CookieDto(cookie);
    }


}
