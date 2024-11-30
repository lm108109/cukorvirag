package org.example.twenty_points.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.twenty_points.exception.ServiceException;
import org.example.twenty_points.exception.StrorageException;
import org.example.twenty_points.model.dto.StorageDto;
import org.example.twenty_points.model.entity.Storage;
import org.example.twenty_points.repository.StorageRepository;
import org.example.twenty_points.service.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Storage API")
@RestController
@CrossOrigin
@RequestMapping("/rest/auth")
public class StorageController {

    private final StorageService storageService;
    private final StorageRepository storageRepository;

    public StorageController(StorageService storageService, StorageRepository storageRepository) {
        this.storageService = storageService;
        this.storageRepository = storageRepository;
    }

    @Operation(summary = "add item to storage")
    @PostMapping("/add-item")
    public ResponseEntity<StorageDto> addItem(@RequestParam String name, @RequestParam Long quantity) {
        Storage storage = storageRepository.findByIngredientName(name);
        if (storage != null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        else {
            return ResponseEntity.ok(storageService.updateStorage(name, quantity));
        }
    }

    @Operation(summary = "modify-quantity")
    @PutMapping("/change-quantity")
    public ResponseEntity<StorageDto> changeQuantity(@RequestParam String name, @RequestParam Long quantity) {
        Storage storage = storageRepository.findByIngredientName(name);
        if (storage != null) {
            return ResponseEntity.ok(storageService.updateStorage(name, quantity));
        }
        else {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }

    @Operation(summary = "get-storage")
    @PutMapping("/get-storage")
    public ResponseEntity<List<StorageDto>> getStorage() {
        return ResponseEntity.ok(storageService.getStorage());
    }

}
