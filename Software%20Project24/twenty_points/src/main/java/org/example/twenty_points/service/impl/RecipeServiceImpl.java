package org.example.twenty_points.service.impl;

import org.example.twenty_points.model.dto.RecipeDto;
import org.example.twenty_points.repository.RecipeRepository;
import org.example.twenty_points.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<RecipeDto> getRecipes() {
        return recipeRepository.findAll().stream()
                .map(RecipeDto::new)
                .toList();
    }
}
