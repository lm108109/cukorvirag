package org.example.twenty_points.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Registration data transfer object")
public class RegistrationModifyDto {

    @NotBlank
    @Size(min = 3, message = "Short name")
    private String name;

    @NotBlank
    @Size(min = 3, message = "Short Username")
    private String username;

    @NotBlank
    private String roleCode;

    @NotNull
    private Boolean active;
}
