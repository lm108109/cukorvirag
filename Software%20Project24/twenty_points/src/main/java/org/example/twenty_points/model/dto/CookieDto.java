package org.example.twenty_points.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.twenty_points.model.entity.Cookie;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Cookie data transfer object")
public class CookieDto {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public CookieDto(Cookie cookie) {
        this.name = cookie.getName();
        this.description = cookie.getDescription();

    }
}
