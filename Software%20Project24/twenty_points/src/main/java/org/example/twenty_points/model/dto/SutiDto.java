package org.example.twenty_points.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.twenty_points.model.entity.Suti;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Suti data transfer objecct")
public class SutiDto {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public SutiDto(Suti suti) {
        this.name = suti.getName();
        this.description = suti.getDescription();

    }
}
