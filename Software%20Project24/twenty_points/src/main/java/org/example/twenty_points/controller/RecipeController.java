package org.example.twenty_points.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.twenty_points.model.dto.OrderDto;
import org.example.twenty_points.model.dto.RecipeDto;
import org.example.twenty_points.repository.RecipeRepository;
import org.example.twenty_points.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Recipe API")
@RestController
@CrossOrigin
@RequestMapping("/rest/auth")
public class RecipeController {

    // CSAK GET !!!!!!!!!!!!!!!!!!!!!!444444!!!!!!!!!!!!
    private final RecipeService recipeService;
    private final RecipeRepository recipeRepository;

    public RecipeController(RecipeService recipeService, RecipeRepository recipeRepository) {
        this.recipeService = recipeService;
        this.recipeRepository = recipeRepository;
    }

    @Operation(summary = "get-recipes")
    @GetMapping("/get-recipes")
    public ResponseEntity<List<RecipeDto>> getOrder()
    {
        return ResponseEntity.ok(recipeService.getRecipes());
    }

}
