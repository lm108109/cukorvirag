package org.example.twenty_points.service;

import org.example.twenty_points.model.dto.RecipeDto;

import java.util.List;


public interface RecipeService {

    List<RecipeDto> getRecipes();
}
