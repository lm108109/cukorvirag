package org.example.twenty_points.controller;

import org.example.twenty_points.model.dto.RecipeDto;
import org.example.twenty_points.repository.RecipeRepository;
import org.example.twenty_points.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RecipeControllerTest {
	
	private RecipeService recipeService;
	private RecipeRepository recipeRepository;
	private RecipeController recipeController;
	
	@BeforeEach
	void setUp() {
		recipeService = mock(RecipeService.class);
		recipeRepository = mock(RecipeRepository.class);
		recipeController = new RecipeController(recipeService, recipeRepository);
	}
	
	@Test
	void getOrderShouldReturnListOfRecipes() {
		List<RecipeDto> recipes = Collections.singletonList(new RecipeDto());
		when(recipeService.getRecipes()).thenReturn(recipes);
		
		ResponseEntity<List<RecipeDto>> response = recipeController.getOrder();
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(recipes);
	}
	
	@Test
	void getOrderShouldReturnEmptyListWhenNoRecipes() {
		when(recipeService.getRecipes()).thenReturn(Collections.emptyList());
		
		ResponseEntity<List<RecipeDto>> response = recipeController.getOrder();
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEmpty();
	}
}
