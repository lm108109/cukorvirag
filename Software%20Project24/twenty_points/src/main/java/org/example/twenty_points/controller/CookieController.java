package org.example.twenty_points.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.twenty_points.model.dto.CookieDto;
import org.example.twenty_points.model.entity.Cookie;
import org.example.twenty_points.repository.CookieRepository;
import org.example.twenty_points.service.CookieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Suti API")
@RestController
@CrossOrigin
@RequestMapping("/rest/auth")
public class CookieController {

    private final CookieService cookieService;
    private final CookieRepository cookieRepository;

    public CookieController(CookieService cookieService, CookieRepository repository) {
        this.cookieService = cookieService;
        this.cookieRepository = repository;
    }

    @Operation(summary = "get-cookies")
    @GetMapping("/get-cookies")
    public ResponseEntity<List<CookieDto>> getCookie() {
        return ResponseEntity.ok(cookieService.getCookie());
    }

    @Operation(summary = "get-cookie-by-id")
    @GetMapping("/get-cookies-by-id")
    public ResponseEntity<CookieDto> getCookieById(@RequestParam Long id) {
        Cookie cookie = cookieRepository.findById(id).orElse(null);
        if (cookie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new CookieDto(cookie));
    }

    @Operation(summary = "add item to storage")
    @PostMapping("/add-cookie")
    public ResponseEntity<CookieDto> addCookie(@RequestParam String name, @RequestParam String description) {
        Cookie cookie = cookieRepository.findCookieByName(name);
        if (cookie == null ) {
            return ResponseEntity.ok(cookieService.addCookie(name, description));
        }
        else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }
}
