package com.java.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import static com.java.app.util.AppEnum.ROLE;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private ROLE role;

    private String name;
    private String email;

    public User(Long id) {
        super();
        setId(id);
    }

    public User(String name, String email, ROLE role) {
        super();
        setName(name);
        setRole(role);
        setEmail(email);
    }
}
