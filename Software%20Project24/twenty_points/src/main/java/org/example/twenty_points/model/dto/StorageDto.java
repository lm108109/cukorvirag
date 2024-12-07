package org.example.twenty_points.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.example.twenty_points.model.entity.Storage;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Storage data transfer objecct")
public class StorageDto {

    private String name;

    private Long quantity;

    public StorageDto(Storage storage) {
        this.name = storage.getIngredientName();
        this.quantity = storage.getQuantity();
    }

    public void setIngredientName(String ingredientName) {
        this.name = ingredientName;
    }
}
