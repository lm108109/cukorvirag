package org.example.twenty_points.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class user {

    @Id
    private int id;

    private String username;

    private String password;

    private Date creationDate;
}
