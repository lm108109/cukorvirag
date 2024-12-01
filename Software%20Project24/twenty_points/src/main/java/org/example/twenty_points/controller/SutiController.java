package org.example.twenty_points.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.twenty_points.model.dto.StorageDto;
import org.example.twenty_points.model.dto.SutiDto;
import org.example.twenty_points.model.entity.Storage;
import org.example.twenty_points.model.entity.Suti;
import org.example.twenty_points.repository.SutiRepository;
import org.example.twenty_points.service.SutiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Suti API")
@RestController
@CrossOrigin
@RequestMapping("/rest/auth")
public class SutiController {

    private final SutiService sutiService;
    private final SutiRepository sutiRepository;

    public SutiController(SutiService sutiService, SutiRepository repository) {
        this.sutiService = sutiService;
        this.sutiRepository = repository;
    }

    @Operation(summary = "get-sutis")
    @GetMapping("/get-sutis")
    public ResponseEntity<List<SutiDto>> getSuti() {
        return ResponseEntity.ok(sutiService.getSuti());
    }

    @Operation(summary = "get-suti-by-id")
    @GetMapping("/get-sutis-by-id")
    public ResponseEntity<SutiDto> getSutiById(@RequestParam Long id) {
        Suti suti = sutiRepository.findById(id).orElse(null);
        if (suti == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new SutiDto(suti));
    }

    @Operation(summary = "add item to storage")
    @PostMapping("/add-suti")
    public ResponseEntity<SutiDto> addSuti(@RequestParam String name, @RequestParam String description) {
        Suti suti = sutiRepository.findSutiByName(name);
        if (suti == null ) {
            return ResponseEntity.ok(sutiService.addSuti(name, description));
        }
        else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }
}
