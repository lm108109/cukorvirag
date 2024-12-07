package org.example.twenty_points.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.twenty_points.repository.RecipeRepository;
import org.example.twenty_points.service.RecipeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Recipe API")
@RestController
@CrossOrigin
@RequestMapping("/rest/auth")
public class RecipeController {

    // CSAK GET !!!!!!!!!!!!!!!!!!!!!!444444!!!!!!!!!!!!
//    private final RecipeService recipeService;
//    private final RecipeRepository recipeRepository;
//
//    public RecipeController(RecipeService recipeService, RecipeRepository recipeRepository) {
//        this.recipeService = recipeService;
//        this.recipeRepository = recipeRepository;
//    }

}
