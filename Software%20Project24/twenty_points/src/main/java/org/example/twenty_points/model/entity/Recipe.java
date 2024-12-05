package org.example.twenty_points.model.entity;

import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Recipes")
public class Recipe {

    @Id
    @JsonIgnore
    @JoinColumn(name = "cookie_id")
    private Long sutiId;

    @Id
    @JsonIgnore
    @JoinColumn(name = "storage_id")
    private Long ingredientId;

    @Column(name = "quantity")
    private Long requiredQuantity;

}
