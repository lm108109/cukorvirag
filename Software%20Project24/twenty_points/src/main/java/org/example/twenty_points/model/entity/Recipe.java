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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @JoinColumn(name = "cookie_id")
    private Long cookieId;


    @JsonIgnore
    @JoinColumn(name = "storage_id")
    private Long storageId;

    @Column(name = "quantity")
    private Double requiredQuantity;

    @Column(name = "unit")
    private String unit;

}
