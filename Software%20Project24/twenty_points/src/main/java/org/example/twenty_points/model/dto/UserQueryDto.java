package org.example.twenty_points.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.twenty_points.model.entity.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "User query data transfer object")
public class UserQueryDto {

    private long id;

    private String name;

    private boolean active;

    private String username;

    private String password;

    private String role;

    public UserQueryDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.active = user.getActive();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.role = user.getRole().getName();
    }
}
