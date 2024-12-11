package org.example.twenty_points.service.impl;

import org.example.twenty_points.model.dto.RecipeDto;
import org.example.twenty_points.model.entity.Recipe;
import org.example.twenty_points.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class RecipeServiceImplTest {
	
	@Mock
	private RecipeRepository recipeRepository;
	
	@InjectMocks
	private RecipeServiceImpl recipeService;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void getRecipesReturnsListOfRecipes() {
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		
		when(recipeRepository.findAll()).thenReturn(List.of(recipe));
		
		List<RecipeDto> recipes = recipeService.getRecipes();
		
		assertEquals(1, recipes.size());
	}
	
	@Test
	void getRecipesReturnsEmptyListWhenNoRecipes() {
		when(recipeRepository.findAll()).thenReturn(List.of());
		
		List<RecipeDto> recipes = recipeService.getRecipes();
		
		assertEquals(0, recipes.size());
	}
}
