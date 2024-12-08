package org.example.twenty_points.repository;

import org.example.twenty_points.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {


    List<Recipe> findByCookieId(Long id);
}
