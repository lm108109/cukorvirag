package org.example.twenty_points.model.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.twenty_points.model.entity.Recipe;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Recipe data transfer objecct")
public class RecipeDto {

    private Long cookieId;

    private Long storageId;

    private Double quantity;

    private String unit;

    public RecipeDto(Recipe recipe) {
        this.cookieId = recipe.getCookieId();
        this.storageId = recipe.getStorageId();
        this.quantity = recipe.getRequiredQuantity();
    }
}
