package org.example.twenty_points.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Required data to login")
public class LoginRequest {

    @NotBlank(message = "Username is required!")
    @Schema(description = "Username of the user")
    private String username;

    @NotBlank(message = "Password is required!")
    @Schema(description = "password of the user")
    private String password;

}
